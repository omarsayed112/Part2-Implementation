import java.util.Arrays;
public class NoviceCompetitor extends Competitor {


    // Constructor
    public NoviceCompetitor(int competitorNumber, String name, String country, int[] scores, String level, String gender, int age) {
        super( competitorNumber, name, country, scores, gender, level, age);
    }

    @Override
    public double getOverallScore() {
        return Arrays.stream(getScores()).average().orElse(0);
    }

    @Override
    public String getFullDetails() {
        return String.format("Competitor number %d, name %s, country %s.%n%s is a %s aged %d and received these scores: %s.%nThis gives them an overall score of %.2f.",
                getCompetitorNumber(), getName(), getCountry(), getName(), getLevel(), getAge(), Arrays.toString(getScores()), getOverallScore());
    }

    @Override
    public String getShortDetails() {
        String initials = Arrays.stream(getName().split(" ")).map(s -> s.substring(0, 1)).reduce("", String::concat);
        return String.format("CN %d (%s) has an overall score of %.2f.", getCompetitorNumber(), initials, getOverallScore());
    }

}


