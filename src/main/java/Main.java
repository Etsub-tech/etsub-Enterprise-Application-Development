import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "bethelsis@28";

    public static void main(String[] args) {

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create the database
            statement.executeUpdate(
                    "CREATE DATABASE IF NOT EXISTS StudentsDB"
            );

            System.out.println("Connected to MySQL successfully!");
            System.out.println("StudentsDB database created successfully!");

            // Connect to StudentsDB
            try (Connection dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/StudentsDB",
                    USER,
                    PASSWORD
            );
                 Statement dbStatement = dbConnection.createStatement()) {

                // Create students table
                String sql = """
                        CREATE TABLE IF NOT EXISTS students (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            firstname VARCHAR(50),
                            lastname VARCHAR(50),
                            grade DOUBLE
                        )
                        """;

                dbStatement.executeUpdate(sql);

                System.out.println("Students table created successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}