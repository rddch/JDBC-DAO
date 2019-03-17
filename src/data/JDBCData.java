package data;

import java.sql.*;

public class JDBCData {

    public static final String URL = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "4773";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO data (id, name, dt) VALUES (?,?,?)");
//            preparedStatement.setString(1, "2");
//            preparedStatement.setString(2, "now");
//            preparedStatement.setDate(3, new Date(1552681658889L));
//            preparedStatement.execute();
//
//            System.out.println(preparedStatement);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM data");
            while (resultSet.next()) {
                System.out.println(resultSet.getDate("dt"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
