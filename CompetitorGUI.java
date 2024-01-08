import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorGUI extends JFrame {
    private CompetitorList competitorList;
    private JTable table;

    public CompetitorGUI() {
        competitorList = new CompetitorList();
        competitorList.readCompetitorsFromCSV("RunCompetitor.csv");

        initializeUI();
    }

    public CompetitorGUI(CompetitorList competitorList) {
        competitorList = new CompetitorList();
        competitorList.readCompetitorsFromCSV("RunCompetitor.csv");

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Competitor GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"Competitor Number", "Name", "Country", "Level", "Age", "Overall Score"}, 0);

        // Populate table model with competitor data
        for (Competitor competitor : competitorList.getAllCompetitors()) {
            tableModel.addRow(new Object[]{
                    competitor.getCompetitorNumber(),
                    competitor.getName(),
                    competitor.getCountry(),
                    competitor.getLevel(),
                    competitor.getAge(),
                    competitor.getOverallScore()
            });
        }


        table = new JTable(tableModel);

        JButton editScoresButton = new JButton("Edit Scores");
        JButton viewDetailsButton = new JButton("View Details");
        JButton closeButton = new JButton("Close");

        // Add action listeners
        editScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openEditScoresDialog();
            }
        });

        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDetails();
            }
        });


        closeButton.addActionListener(e -> {
            competitorList.generateFinalReport();
            System.exit(0);
        });

        // Create layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editScoresButton);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Set up frame
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void openEditScoresDialog() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Competitor competitor = competitorList.getAllCompetitors().get(selectedRow);

            JPanel panel = new JPanel(new GridLayout(6, 2));

            panel.add(new JLabel("Competitor Number:"));
            JTextField competitorNumberField = new JTextField(String.valueOf(competitor.getCompetitorNumber()));
            competitorNumberField.setEditable(false);
            panel.add(competitorNumberField);

            panel.add(new JLabel("Name:"));
            JTextField nameField = new JTextField(competitor.getName());
            nameField.setEditable(false);
            panel.add(nameField);

            panel.add(new JLabel("Enter New Scores:"));
            JTextField[] scoreFields = new JTextField[5];
            for (int i = 0; i < 5; i++) {
                scoreFields[i] = new JTextField(String.valueOf(competitor.getScores()[i]));
                panel.add(scoreFields[i]);
            }

            int result = JOptionPane.showConfirmDialog(this, panel, "Edit Scores", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // User clicked OK, save the edited scores
                int[] newScores = new int[5];
                for (int i = 0; i < 5; i++) {
                    newScores[i] = Integer.parseInt(scoreFields[i].getText());
                }
                competitor.setScores(newScores);

                // Update the table
                updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a competitor to edit scores.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        for (Competitor competitor : competitorList.getAllCompetitors()) {
            tableModel.addRow(new Object[]{
                    competitor.getCompetitorNumber(),
                    competitor.getName(),
                    competitor.getCountry(),
                    competitor.getLevel(),
                    competitor.getAge(),
                    competitor.getOverallScore()
            });
        }
    }


    private void viewDetails() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Competitor competitor = competitorList.getAllCompetitors().get(selectedRow);

            JTextArea detailsTextArea = new JTextArea();
            detailsTextArea.setEditable(false);
            detailsTextArea.append(competitor.getFullDetails());

            JScrollPane scrollPane = new JScrollPane(detailsTextArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Competitor Details", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a competitor to view details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CompetitorGUI();
            }
        });
    }
}