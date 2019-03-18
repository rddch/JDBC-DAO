package test;

import java.sql.*;

public class MainTest {

    public static void main(String[] args) {

        DaoSet myDao = new DaoSet();
        Receiver receiver = new Receiver(5, "Ангелина");
        Expense expense = new Expense(6, 90, new Date(System.currentTimeMillis()));

        myDao.addReceiver(receiver);
        myDao.getReceiver(3);

        expense.setReceiver(receiver);
        myDao.addExpense(expense);
        myDao.getExpense(1);
    }
}
