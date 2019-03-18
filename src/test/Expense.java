package test;

import java.util.Date;

public class Expense {

    private int num;
    private int value;
    private Receiver receiver;
    private Date date;

    public Expense(int num, int value, Date date) {
        this.num = num;
        this.value = value;
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public int getValue() {
        return value;
    }
    public Date getDate() { return date; }

    public void setReceiver(Receiver receiver) { this.receiver = receiver; }

    public Receiver getReceiver() { return receiver; }





}
