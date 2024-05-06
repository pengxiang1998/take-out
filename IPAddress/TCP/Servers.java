package IPAddress.TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //创建ServerSocket对象，并指明端口号，方便接收客户端数据
        ServerSocket serverSocket = new ServerSocket(8088);
        //调用accept方法,等待客户端的连接请求
        Socket accept = serverSocket.accept();
        //从socket的通信管道中得到一个字节输入流
        InputStream inputStream = accept.getInputStream();
        //将原始的字节输入流包装成高级的数据输入流
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //使用数据输入流读取客户端发送的数据
        while (true) {
            try {
                String string = dataInputStream.readUTF();//通信很严格，要保持一致
                System.out.println(string);
            } catch (IOException e) {
                System.out.println(accept.getInetAddress()+"客户端退出了！");//输出发送客户端的IP地址
                dataInputStream.close();
                serverSocket.close();
                break;
            }
        }

    }
}
