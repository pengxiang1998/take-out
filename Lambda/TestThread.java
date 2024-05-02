package Lambda;

public class TestThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                System.out.println("线程启动"+thread);
            }
        }).start();
        new Thread(()->{
            Thread thread = Thread.currentThread();
            System.out.println("线程启动"+thread);
        }).start();
        new Test(){
            @Override
            public void eat() {
                System.out.println("吃饭");
            }
        }.eat();
        int i = count1(new Count() {
            @Override
            public int count(int left, int right) {
                return left + right;
            }
        });
        System.out.println(i);
        count1((int left,int right)->{
            return left + right;
        });

        printNum(new Count1() {
            @Override
            public boolean test(int m) {
                return m%2==0;
            }
        });
        printNum((int n)->{
            return n%2==0;
        });

    }
    public static int count1(Count count){
        int left=10;
        int right=20;
        return count.count(left,right);
    }
    public static void printNum(Count1 count){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        for(int i:arr){
            if(count.test(i)){
                System.out.println(i);
            }
        }
    }

}
interface Test{
    public void eat();
}
interface Count{
    int count(int left, int right);

}
interface Count1{
    boolean test(int i);
}

