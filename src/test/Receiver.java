package test;

public class Receiver {

    private String name;
    private int num;

    Receiver(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

}
