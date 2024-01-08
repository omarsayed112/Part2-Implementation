import java.util.Arrays;
public class IntermediateCompetitor extends Competitor {
    private String level;
    private int age;

    // Constructor
    public IntermediateCompetitor(int competitorNumber, String name, String country, int[] scores, String level, int age, String gender) {
        super(competitorNumber, name, country, scores, gender, level, age);
        this.level = level;
        this.age = age;
    }

    @Override
    public double getOverallScore() {
        double averageScore = Arrays.stream(getScoreArray()).average().orElse(0);
        double weightedScore = averageScore * getLevelWeight();
        return weightedScore;
    }

    @Override
    public String getFullDetails() {
        // Implement how full details are represented for IntermediateCompetitor
        return String.format("Intermediate Competitor: %s, Level: %s, Country: %s",
                getName(), level, getCountry());
    }

    @Override
    public String getShortDetails() {
        return String.format("ICN %d (%s) has an overall score of %.2f.", getCompetitorNumber(), getInitials(), getOverallScore());
    }
    
    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public int getAge() {
        return age;
    }

    // Helper method to get the weight based on the level
    private double getLevelWeight() {
        switch (level.toLowerCase()) {
            case "beginner":
                return 1.0;
            case "intermediate":
                return 1.5;
            case "advanced":
                return 2.0;
            default:
                return 1.0;
        }
    }
}


