package test;

import java.sql.*;

public class MainTest {

    public static void main(String[] args) {

        Long date = System.currentTimeMillis();

        DaoSet myDao = new DaoSet();
        Receiver receiver = new Receiver();
        Expense expense = new Expense();

        receiver.setNum(4);
        receiver.setName("Николай");
        myDao.addReceiver(receiver);
        myDao.getReceiver(3);

        expense.setReceiver(receiver);
        expense.setNum(2);
        expense.setValue(120);
        expense.setDate(new Date(date));
        myDao.addExpense(expense);
        myDao.getExpense(2);
    }
}
