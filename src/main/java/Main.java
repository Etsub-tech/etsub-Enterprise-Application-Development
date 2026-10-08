import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/university_db";
        String username = "root";
        String password = "bethelsis@28";



        String sql = "INSERT INTO students (name, age, department) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "Etsub");
            statement.setInt(2, 22);
            statement.setString(3, "Software Engineering");

            statement.executeUpdate();

            System.out.println("Student added successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}