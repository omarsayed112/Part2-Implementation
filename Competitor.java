import java.util.Arrays;

public abstract class Competitor {
    private int competitorNumber;
    private String name;
    private String country;
    private int[] scores;

    // Constructor
    public Competitor(int competitorNumber, String name, String country, int[] scores) {
        this.competitorNumber = competitorNumber;
        this.name = name;
        this.country = country;
        this.scores = scores;
    }

    // Get and Set methods

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int[] getScores() {
        return scores;
    }

    // Abstract methods
    
    // Method to get the overall score (to be implemented by subclasses)
    public abstract double getOverallScore();

    // Method to get full details (to be implemented by subclasses)
    public abstract String getFullDetails();

    // Method to get short details (to be implemented by subclasses)
    public abstract String getShortDetails();
    
    public abstract String getLevel();
    
    public abstract int getAge();
    
    // Method to get the array of scores
    public int[] getScoreArray() {
        return scores;
    }
    
    //Method to get Initials
    protected String getInitials() {
        return Arrays.stream(name.split(" ")).map(s -> s.substring(0, 1)).reduce("", String::concat);
    }
}


