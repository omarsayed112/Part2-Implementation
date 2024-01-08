import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Arrays;

public class CompetitorList {
    private ArrayList<Competitor> competitors;

    public CompetitorList() {
        this.competitors = new ArrayList<>();
    }

    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    public Competitor getCompetitor(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }

    public ArrayList<Competitor> getAllCompetitors() {
        return new ArrayList<>(competitors); // Return a copy to prevent modification outside the class
    }

    public Competitor getHighestOverallScoreCompetitor() {
        return Collections.max(competitors, Comparator.comparingDouble(Competitor::getOverallScore));
    }

    // Method to print short details for a competitor
    public void printShortDetails(int competitorNumber) {
        Competitor competitor = getCompetitor(competitorNumber);
        if (competitor != null) {
            System.out.println(competitor.getShortDetails());
        } else {
            System.out.println("Invalid competitor number.");
        }
    }

    // Method to read competitor details from a CSV file
    public void readCompetitorsFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming CSV format: competitorNumber,name,country,level,age,score1,score2,score3,score4,score5
                String[] parts = line.split(",");
                int competitorNumber = Integer.parseInt(parts[0]);
                String name = parts[1];
                String country = parts[4];
                String gender = parts[3];
                int age = Integer.parseInt(parts[2]);
                int[] scores = new int[5];
                for (int i = 0; i < 5; i++) {
                    scores[i] = Integer.parseInt(parts[5 + i]);
                }

                Competitor competitor = new IntermediateCompetitor(competitorNumber, name, country, scores, level, age);
                addCompetitor(competitor);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Method to calculate the frequency of each score
    public HashMap<Integer, Integer> calculateScoreFrequency() {
        HashMap<Integer, Integer> scoreFrequency = new HashMap<>();
        for (Competitor competitor : competitors) {
            int[] scores = competitor.getScoreArray();
            for (int score : scores) {
                scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
            }
        }
        return scoreFrequency;
    }

    // Method to get the average overall score
    public double calculateAverageOverallScore() {
        double totalOverallScore = 0;
        for (Competitor competitor : competitors) {
            totalOverallScore += competitor.getOverallScore();
        }
        return totalOverallScore / competitors.size();
    }

    // Method to generate and print the final report
    public void generateFinalReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("FinalReport.txt"))) {
            writer.write("Competitor Details:\n");
            writer.write(String.format("%-15s %-25s %-15s %-10s %-5s %-30s\n",
                    "CompetitorNum", "Name", "Country", "Level", "Age", "Scores"));
            for (Competitor competitor : competitors) {
                writer.write(String.format("%-15s %-25s %-15s %-10s %-5s %-30s\n",
                        competitor.getCompetitorNumber(), competitor.getName(),
                        competitor.getCountry(), competitor.getLevel(), competitor.getAge(),
                        Arrays.toString(competitor.getScoreArray())));
            }
            writer.newLine();

            // Details of the competitor with the highest overall score
            Competitor highestScoreCompetitor = getHighestOverallScoreCompetitor();
            writer.write("Competitor with Highest Overall Score:\n");
            writer.write(highestScoreCompetitor.getFullDetails());
            writer.newLine();

            // Summary statistics
            writer.write("Summary Statistics:\n");
            writer.write(String.format("Average Overall Score: %.2f\n", calculateAverageOverallScore()));

            // Frequency report
            writer.write("Frequency Report:\n");
            HashMap<Integer, Integer> scoreFrequency = calculateScoreFrequency();
            for (int score : scoreFrequency.keySet()) {
                writer.write(String.format("Score %d: %d times\n", score, scoreFrequency.get(score)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFileReading() {
        System.out.println("=== Testing Reading Competitors from a File ===");

        // Create a CompetitorList
        CompetitorList competitorList = new CompetitorList();

        // Read competitors from a CSV file
        competitorList.readCompetitorsFromCSV("C:\\Users\\user\\OneDrive\\Desktop\\Software Architecture\\RunCompetitor.csv");

        // Display details of all competitors
        for (Competitor competitor : competitorList.getAllCompetitors()) {
            System.out.println(competitor.getShortDetails());
        }
    }

}



