package projeсt;


import java.sql.*;


public class Main {

    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/books_db?useSSL=false";
        String USERNAME = "root";
        String PASSWORD = "4773";

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // загрузка драйвера
//        } catch (ClassNotFoundException e) {
//            System.out.println("File not found!!");
//            e.printStackTrace();
//        }

//            try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()){

//            String userId = "1";
            String userId = "1' or 1 = '1";
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM author WHERE id = '" + userId + "'");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
//                                    + " " + resultSet.getString(3) + " " + resultSet.getString(4));
//            }
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM author WHERE id = ?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1) + " " + resultSet2.getString(2)
                        + " " + resultSet2.getString(3) + " " + resultSet2.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
