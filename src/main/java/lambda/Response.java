/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.lang.annotation.Native;
import java.util.List;

/**
 *
 * @author wlloyd
 */
public class Response extends saaf.Response {
    
    //
    // User Defined Attributes
    //
    //
    // ADD getters and setters for custom attributes here.
    //

    // Return value
    private String value;

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }

    public List<String> names;
    public List<String> getNames()
    {
        return this.names;
    }
    public void setNames(List<String> names)
    {
        this.names = names;
    }
    public String getNamesString()
    {
        StringBuilder sb = new StringBuilder();
        for (String s : this.names)
        {
            sb.append(s + "; ");
        }
        return sb.toString();
    }
    
    @Override
    public String toString()
    {
        return "value=" + this.getValue() + " " + this.getNamesString() + " " + super.toString(); 
    }

}
