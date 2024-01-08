import javax.swing.*;

public class Manager {
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromCSV("RunCompetitor.csv");
        SwingUtilities.invokeLater(() -> {
            CompetitorGUI competitorGUI = new CompetitorGUI(competitorList);
        });
        competitorList.printShortDetails(100);
        competitorList.generateFinalReport();
    }
}

