import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "bethelsis@28";

        try {
            // 1. Create connection
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Connected to MySQL successfully!");

            // 2. Create statement
            Statement statement = connection.createStatement();

            // 3. Create database
            statement.executeUpdate(
                    "CREATE DATABASE IF NOT EXISTS StudentsDB"
            );

            System.out.println("StudentsDB created successfully!");

            // 4. Connect to the StudentsDB database
            connection.close();

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/StudentsDB",
                    username,
                    password
            );

            // 5. Create statement for StudentsDB
            statement = connection.createStatement();

            // 6. Create students table
            String sql = """
                    CREATE TABLE IF NOT EXISTS students (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        firstname VARCHAR(50),
                        lastname VARCHAR(50),
                        grade DOUBLE
                    )
                    """;

            // 7. Execute the SQL
            statement.executeUpdate(sql);

            System.out.println("Students table created successfully!");

            // 8. Close resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}