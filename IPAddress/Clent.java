package IPAddress;

import java.io.IOException;
import java.net.*;

public class Clent {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        DatagramSocket socket = new DatagramSocket();
        //创建数据包封装对象，存储数据信息
//        public DatagramPacket(byte buf[], int offset, int length,
//        InetAddress address, int port) {
//            setData(buf, offset, length);
//            setAddress(address);
//            setPort(port);
//        }
        byte[] bytes = "客户端消息:我是鹏翔".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),8888);
        //发送数据包
        socket.send(packet);
        System.out.println("客户端数据发送完毕");
        socket.close();

    }
}
