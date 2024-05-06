package IPAddress.BS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> sockets=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //创建ServerSocket对象，并指明端口号，方便接收客户端数据
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("子线程启动");
            sockets.add(accept);

        }
    }
}
