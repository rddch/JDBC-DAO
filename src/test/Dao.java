package test;

import java.util.ArrayList;

public interface Dao {
    void getReceiver(int num);
    ArrayList<Receiver> getReceivers();
    void getExpense(int num);
    ArrayList<Expense> getExpenses();
    int addReceiver(Receiver receiver);
    int addExpense(Expense expense);
}
