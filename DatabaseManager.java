import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static DatabaseManager instance;
    private static Connection connection;

    private DatabaseManager() {
        // Private constructor to enforce singleton pattern
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public static void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaxSubarraySumDB", "your_username", "your_password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveToDatabase(String inputArray, int maxContiguousSum) {
        try {
            String query = "INSERT INTO MaxSubarraySum (InputArray, MaxContiguousSum) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inputArray);
            preparedStatement.setInt(2, maxContiguousSum);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other database-related methods can be added as needed
}
