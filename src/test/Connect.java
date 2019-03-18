package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private  final String URL = "jdbc:mysql://localhost:3306/costs?useSSL=false";
    private  final String USERNAME = "root";
    private  final String PASSWORD = "4773";

    private Connection connection;
    private static Connect instance = new Connect();

    private Connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {return connection;}

    public static Connect getInstance() {
        return instance;
    }
}



