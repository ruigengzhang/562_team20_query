package lambda;


import com.amazonaws.services.lambda.runtime.*;
import saaf.Inspector;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class HelloMySQL implements RequestHandler<Request, HashMap<String, Object>> {


    public HashMap<String, Object> handleRequest(Request request, Context context) {

        // Create logger
        LambdaLogger logger = context.getLogger();

        //Collect initial data.
        Inspector inspector = new Inspector();
        inspector.inspectAll();

        //****************START FUNCTION IMPLEMENTATION*************************

        Response response = new Response();
        Connection conn = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("db.properties"));

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            conn = DriverManager.getConnection(url, username, password);
            logger.log("Create Connection Success");
            PreparedStatement ps = conn.prepareStatement("select name from test");

            ResultSet rs = ps.executeQuery();
            List<String> ll = new LinkedList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                ll.add(name);
                logger.log("name=" + rs.getString("name"));
            }

            rs.close();
            response.setNames(ll);
            response.setValue("v");
            response.setVersion("v1");
        } catch (Exception e) {
            logger.log("Got an exception working with MySQL! ");
            logger.log(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.log("[Error] close conn");

            }
        }


        inspector.consumeResponse(response);

        //****************END FUNCTION IMPLEMENTATION***************************

        //Collect final information such as total runtime and cpu deltas.
        inspector.inspectAllDeltas();
        return inspector.finish();
    }


}
