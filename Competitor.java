import java.util.Arrays;

public abstract class Competitor {
    private int competitorNumber;
    private String name;
    private String country;
    private int[] scores;

    private String gender;

    private String level;

    private int age;

    // Constructor
    public Competitor(int competitorNumber, String name, String country, int[] scores, String gender, String level, int age) {
        this.competitorNumber = competitorNumber;
        this.name = name;
        this.country = country;
        this.scores = scores;
        this.gender = gender;
        this.level = level;
        this.age = age;
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
    
    public String getLevel(){
        return level;
    }

    public int getAge(){
        return age;
    }
    
    // Method to get the array of scores
    public int[] getScoreArray() {
        return scores;
    }
    
    //Method to get Initials
    protected String getInitials() {
        return Arrays.stream(name.split(" ")).map(s -> s.substring(0, 1)).reduce("", String::concat);
    }
}


