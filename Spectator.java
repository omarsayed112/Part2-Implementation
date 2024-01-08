public class Spectator {
    private int spectatorID;
    private String name;

    // Constructor
    public Spectator(int spectatorID, String name) {
        this.spectatorID = spectatorID;
        this.name = name;
    }

    // Getters
    public int getSpectatorID() {
        return spectatorID;
    }

    public String getName() {
        return name;
    }

    // Method to watch the competition
    public void watchCompetition(Competition competition) {
        System.out.println(name + " is watching the competition: " + competition.getName());

        // Simulate watching the competition
        System.out.println("The competition is in progress. Enjoy the show!");
    }

    // Method to view results of the competition
    public void viewResults(Competition competition) {
        System.out.println(name + " is viewing the results of the competition: " + competition.getName());
        System.out.println("And the winner is... " + competition.getWinner());
    }
}
