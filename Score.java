public class Score {
    private int scoreID;
    private int value;
    private String category;
    private Competitor competitor;

    // Constructor
    public Score(int scoreID, int value, String category, Competitor competitor) {
        this.scoreID = scoreID;
        this.value = value;
        this.category = category;
        this.competitor = competitor;
    }

    // Method to record score
    public void recordScore(int score) {
        if (competitor == null) {
            System.out.println("Invalid competitor.");
            return;
        }
        System.out.println("Recording score " + score + " for competitor " + competitor.getName() + " in category "
                + category);
    }
}

