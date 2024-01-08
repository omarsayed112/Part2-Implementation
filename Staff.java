public class Staff {
    private int staffID;
    private String name;
    private int accessLevel;

    // Constructor
    public Staff(int staffID, String name, int accessLevel) {
        this.staffID = staffID;
        this.name = name;
        this.accessLevel = accessLevel;
    }

    // Method to manage competitor details
    public void manageCompetitorDetails(Competitor competitor) {
        if (competitor == null) {
            System.out.println("Invalid competitor.");
            return;
        }

        System.out.println(name + " with staff ID " + staffID + " is managing details for competitor " + competitor.getName());
    }

    // Method to manage competition
    public void manageCompetition(Competition competition) {
        if (competition == null) {
            System.out.println("Invalid competition.");
            return;
        }

        System.out.println(name + " with staff ID " + staffID + " is managing competition " + competition.getName());
    }
}
