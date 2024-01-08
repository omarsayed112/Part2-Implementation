public class Emergency {
    private int serviceID;
    private String serviceName;

    // Constructor
    public Emergency(int serviceID, String serviceName) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
    }

    // provideSupport Method
    public void provideSupport(Competitor competitor, String supportType) {
        if (competitor == null) {
            System.out.println("Invalid competitor.");
            return;
        }System.out.println(serviceName + " is providing " + supportType + " support to competitor " + competitor.getName());
    }
}
