import java.util.List;

public class Competition {
    private int competitionID;
    private String name;
    private List<Level> categories;
    private List<Competitor> competitors;
    private Level level;

    // Constructor
    public Competition(int competitionID, String name, List<Level> categories, List<Competitor> competitors, Level level) {
        this.competitionID = competitionID;
        this.name = name;
        this.categories = categories;
        this.competitors = competitors;
        this.level = level;
    }

    // Getters
    public int getCompetitionID() {
        return competitionID;
    }
    public String getName() {
        return name;
    }
    public List<Level> getCategories() {
        return categories;
    }
    public List<Competitor> getCompetitors() {
        return competitors;
    }

    // Methods
    public void startCompetition() {
        // Implement the logic to start the competition
        System.out.println("Competition started!");
    }

    public void endCompetition() {
        // Implement the logic to end the competition
        System.out.println("Competition ended!");
    }

    public Competitor getWinner() {
        if (competitors.isEmpty()) {
            System.out.println("No competitors in the competition.");
            return null;
        }Competitor winner = competitors.get(0);
        for (Competitor competitor : competitors) {
            if (competitor.getOverallScore() > winner.getOverallScore()) {
                winner = competitor;
            }
        }System.out.println("The winner of the competition is: " + winner.getName());
        return winner;
    }
}

