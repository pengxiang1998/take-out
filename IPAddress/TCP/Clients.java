package IPAddress.TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Clients {
    public static void main(String[] args) throws IOException {
        //创建Socket对象,并同时请求服务端程序的连接，声明服务器的IP与端口号
        Socket socket = new Socket("127.0.0.1",8088);
        //从socket中获取一个字节输出流，用于给服务端发送
        OutputStream outputStream = socket.getOutputStream();
        //原本的字节输出流并不好用，将其封装为高级的数据输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //开始写数据
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入内容:");
            String string = scanner.nextLine();
            if ("exit".equals(string)) {
                dataOutputStream.close();
                socket.close();
                System.out.println("退出成功！");
                break;
            }
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();//将数据刷新出去，防止数据还留在内存中
        }


    }
}
