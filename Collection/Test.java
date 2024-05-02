package Collection;

public class Test {
    static int x=10;
    static {x+=5;}
    public static void main(String args[]) {

        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };

        t.run();
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
    static{x/=3;};
}//9