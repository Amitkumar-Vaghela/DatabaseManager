import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialize the GUI
                MaxSubarraySumGUI gui = new MaxSubarraySumGUI();

                // Connect to the database
                DatabaseManager.initializeDatabase();

                // Set the GUI to use the DatabaseManager for database operations
                gui.setDatabaseManager(DatabaseManager.getInstance());

                // Make the GUI visible
                gui.setVisible(true);
            }
        });
    }
}
