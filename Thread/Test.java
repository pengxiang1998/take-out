package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1=new MyThread();
        Thread t2=new MyThread();
        t1.setName("线程1");
        t2.setName("线程2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        //System.out.println(Thread.currentThread().getPriority());
        t2.start();
        //定义多线程要执行的任务
//        Thread.MyRunnable mr=new Thread.MyRunnable();
//
//        //创建线程对象
//        Thread t1=new Thread(mr);
//        Thread t2=new Thread(mr);
//        t1.setName("线程1");
//        t2.setName("线程2");
//        t1.start();
//        t2.start();
        //创建Callable对象，表示多线程要执行的任务
//        MyCallable mc=new MyCallable();
//        //原本应该使用Future来管理多线程结果的，但由于Future是个接口，因此我们使用其实现类FutureTask
//        FutureTask<Integer> futureTask=new FutureTask<>(mc);
//        //创建Thread并启动
//        Thread t1=new Thread(futureTask);
//        t1.setName("线程1");
//        t1.start();
//        Integer r1=futureTask.get();
//        System.out.println(r1);



    }
}
