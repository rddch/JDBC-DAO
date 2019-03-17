package test;

import java.sql.*;
import java.util.ArrayList;

public class DaoSet implements Dao {

    public void getReceiver(int num) {
        PreparedStatement preparedStatement;
        String query = "SELECT * FROM receiver WHERE receiver_num = ?;";

        try (Connection connection = DriverManager.getConnection(MainTest.URL, MainTest.USERNAME, MainTest.PASSWORD)) {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, num);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int receiver_num = resultSet.getInt(1);
                String receiver_name = resultSet.getString(2);
                System.out.println(receiver_num + " " + receiver_name);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Receiver> getReceivers() {

        ArrayList<Receiver> lst = new ArrayList<>();
        String query = "SELECT * FROM receiver;";

        try (Connection connection = DriverManager.getConnection(MainTest.URL, MainTest.USERNAME, MainTest.PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Receiver n = new Receiver();
                n.setNum(resultSet.getInt(1));
                n.setName(resultSet.getString(2));
                lst.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public void getExpense(int num) {

        PreparedStatement preparedStatement;
        String query = "SELECT * FROM expense WHERE receiver_num = ?;";

        try (Connection connection = DriverManager.getConnection(MainTest.URL, MainTest.USERNAME, MainTest.PASSWORD)) {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, num);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int receiver_num = resultSet.getInt(4);
                java.util.Date date = resultSet.getDate(3);
                int value = resultSet.getInt(2);
                int expense_id = resultSet.getInt(1);
                System.out.println(expense_id + " " + value + " " + date + " " + receiver_num);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Expense> getExpenses() {

        ArrayList<Expense> expense = new ArrayList<>();
        String query = "SELECT * FROM expense;";

        try (Connection connection = DriverManager.getConnection(MainTest.URL, MainTest.USERNAME, MainTest.PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Expense ex = new Expense();
                ex.setValue(resultSet.getInt(2));
                ex.setDate(resultSet.getDate(3));
                ex.setNum(resultSet.getInt(4));
                expense.add(ex);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    public int addReceiver(Receiver receiver) {
        String name = receiver.getName();
        int num = receiver.getNum();
        String query = "INSERT INTO receiver (receiver_num, receiver_name) VALUES (?,?);";


        try (Connection connection = DriverManager.getConnection(MainTest.URL, MainTest.USERNAME, MainTest.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public int addExpense(Expense expense) {
        int num = expense.getNum();
        int value = expense.getValue();
        String query = "INSERT INTO expense (expense_value, expense_date, receiver_num) VALUES (?, ?, ?);";

        try (Connection connection = DriverManager.getConnection(MainTest.URL, MainTest.USERNAME, MainTest.PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(2, new java.sql.Date(1552841959L));
            preparedStatement.setInt(1, value);
            preparedStatement.setInt(3, num);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
