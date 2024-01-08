import java.util.List;

public class Referee {
    private int refereeID;
    private String name;
    private List<String> assignedCategories;

    // Constructor
    public Referee(int refereeID, String name, List<String> assignedCategories) {
        this.refereeID = refereeID;
        this.name = name;
        this.assignedCategories = assignedCategories;
    }

    // Method to record score
    public void recordScore(Competitor competitor, Score score) {
        if (competitor == null || score == null) {
            System.out.println("Invalid competitor or score.");
            return;
        }
        System.out.println(name + " with referee ID " + refereeID + " is recording a score for competitor "
                + competitor.getName() + " in categories: " + String.join(", ", assignedCategories));
    }
}

