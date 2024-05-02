package Thread.Daemon;

public class MyTread2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            //System.out.println(Thread.currentThread().getPriority());
            System.out.println(getName()+" "+i);
        }
    }
}

