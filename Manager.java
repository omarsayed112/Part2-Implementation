public class Manager {
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromCSV("RunCompetitor.csv");
        competitorList.printShortDetails(100);
        competitorList.generateFinalReport();
    }
}
