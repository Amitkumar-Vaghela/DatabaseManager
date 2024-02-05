import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxSubarraySumGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private DatabaseManager databaseManager;

    public MaxSubarraySumGUI() {
        // GUI initialization code (similar to the previous example)

        // Add a button to save to the database
        JButton saveButton = new JButton("Save to Database");
        add(saveButton);

        // Add action listener to the save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToDatabase();
            }
        });
    }

    public void setDatabaseManager(DatabaseManager manager) {
        this.databaseManager = manager;
    }

    private void saveToDatabase() {
        try {
            String inputText = inputField.getText();
            String[] numbers = inputText.split("\\s+");
            int[] array = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i]);
            }

            int result = findMaxSubarraySum(array);
            resultLabel.setText("Maximum contiguous sum: " + result);

            // Save to the database
            if (databaseManager != null) {
                databaseManager.saveToDatabase(inputText, result);
                JOptionPane.showMessageDialog(this, "Data saved to database!");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid integers.");
        }
    }

    // Rest of the MaxSubarraySumGUI code (similar to the previous example)
}
