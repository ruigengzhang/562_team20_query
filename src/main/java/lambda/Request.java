package lambda;


public class Request {

    private String Region;

    private String ItemType;

    private String SalesChannel;

    private String OrderPriority;

    private String Country;

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public String getSalesChannel() {
        return SalesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        SalesChannel = salesChannel;
    }

    public String getOrderPriority() {
        return OrderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        OrderPriority = orderPriority;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "Request{" +
                "Region='" + Region + '\'' +
                ", ItemType='" + ItemType + '\'' +
                ", SalesChannel='" + SalesChannel + '\'' +
                ", OrderPriority='" + OrderPriority + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
