package test;

import java.sql.*;

public class MainTest {

    public static final String URL = "jdbc:mysql://localhost:3306/costs?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "4773";

    public static void main(String[] args) {

        DaoSet myDao = new DaoSet();
        Receiver receiver = new Receiver();
        Expense expense = new Expense();

        receiver.setNum(1);
        receiver.setName("Руслан");
        myDao.addReceiver(receiver);
        myDao.getReceiver(1);

        for (int i = 0; i < myDao.getReceivers().size(); i++) {
            System.out.println(myDao.getReceivers().get(i).getNum() + " " + myDao.getReceivers().get(i).getName());
        }

        expense.setReceiver(receiver);
        expense.setNum(2);
        expense.setValue(120);
        expense.setDate(new Date(1552871300000L));
        myDao.addExpense(expense);
        myDao.getExpense(2);

        for (int i = 0; i < myDao.getExpenses().size(); i++) {
            System.out.println(myDao.getExpenses().get(i).getValue() + " " + myDao.getExpenses().get(i).getDate() +
            " " + myDao.getExpenses().get(i).getNum());
        }

    }
}
