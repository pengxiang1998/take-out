package IPAddress.BSPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static List<Socket> sockets=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //创建ServerSocket对象，并指明端口号，方便接收客户端数据
        ServerSocket serverSocket = new ServerSocket(9090);
        //通过线程池来控制执行线程的数量与任务队列数量
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                16 * 2, 16 * 2,
                0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(8),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("子线程启动");
            threadPoolExecutor.execute(new ServerReadRunnable(accept));

        }
    }
}
