package IPAddress.GroupChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReadThread extends Thread{
    private Socket socket;
    public ClientReadThread(Socket accept) {
        this.socket=accept;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            //将原始的字节输入流包装成高级的数据输入流
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //使用数据输入流读取客户端发送的数据
            while (true) {
                try {
                    String string = dataInputStream.readUTF();//通信很严格，要保持一致
                    System.out.println(string);
                } catch (IOException e) {
                    System.out.println("自己客户端下线了！");
                    dataInputStream.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("服务异常！" + socket.getInetAddress() + "连接中断！");
        }
    }
}
