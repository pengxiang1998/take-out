package Thread.Daemon;

public class Test {
    public static void main(String[] args) {
        MyTread1 t1=new MyTread1();
        MyTread2 t2=new MyTread2();
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
