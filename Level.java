import java.util.List;

public class Level {
    private int levelID;
    private String name;
    private List<Competition> competitions;

    // Constructor
    public Level(int levelID, String name, List<Competition> competitions) {
        this.levelID = levelID;
        this.name = name;
        this.competitions = competitions;
    }

    // Getters
    public int getLevelID() {
        return levelID;
    }
    public String getName() {
        return name;
    }
    public List<Competition> getCompetitions() {
        return competitions;
    }

    // Method to get level details
    public String getLevelDetails() {
        // Implement the logic to get level details
        return String.format("Level ID: %d, Name: %s", levelID, name);
    }
}

