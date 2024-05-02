package IPAddress;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Serve {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //创建一个服务端对象，并指定端口
        DatagramSocket socket = new DatagramSocket(8888);
        //定义所能够接收的数据的大小
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        //接收数据
        socket.receive(packet);
        int length = packet.getLength();
        String string = new String(packet.getData(), 0, length);
        System.out.println(string);

        socket.close();

    }
}
