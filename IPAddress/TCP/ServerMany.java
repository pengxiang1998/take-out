package IPAddress.TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMany {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //创建ServerSocket对象，并指明端口号，方便接收客户端数据
        ServerSocket serverSocket = new ServerSocket(8088);
        //调用accept方法,等待客户端的连接请求
        Socket accept = null;
        while (true) {
            accept = serverSocket.accept();
            new ServerReadThread(accept).start();
        }
    }
}
