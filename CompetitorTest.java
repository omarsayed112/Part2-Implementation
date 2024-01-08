import java.util.Arrays;

public class CompetitorTest {
    public static void main(String[] args) {
        // Test individual competitors
        testCompetitors();
        // Test reading competitors from a file
        testFileReading();
        // Test generating final reports
        testReporting();
    }

    private static void testCompetitors() {
        System.out.println("=== Testing Individual Competitors ===");

        // Create an IntermediateCompetitor
        IntermediateCompetitor intermediateCompetitor = new IntermediateCompetitor(
                100, "John Doe", "USA", new int[]{4, 3, 5, 2, 4}, "Intermediate", 22, "Male"
        );

        // Create a NoviceCompetitor
        NoviceCompetitor noviceCompetitor = new NoviceCompetitor(
                101, "Alice Smith", "Canada", new int[]{3, 2, 4, 1, 5}, "Novice", "Female", 26
        );

        System.out.println(intermediateCompetitor.getFullDetails());
        System.out.println(noviceCompetitor.getShortDetails());
    }

    private static void testFileReading() {
        System.out.println("=== Testing Reading Competitors from a File ===");

        // Create a CompetitorList
        CompetitorList competitorList = new CompetitorList();

        // Read competitors from a CSV file
        competitorList.readCompetitorsFromCSV("RunCompetitor.csv");

        // Display details of all competitors
        for (Competitor competitor : competitorList.getAllCompetitors()) {
            System.out.println(competitor.getShortDetails());
        }
    }

    private static void testReporting() {
        System.out.println("=== Testing Generating Final Reports ===");
        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromCSV("RunCompetitor.csv");
        competitorList.generateFinalReport();
    }
}

