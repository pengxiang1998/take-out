package IPAddress.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

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
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("请说:");
            String msg = scanner.nextLine();
            if ("exit".equals(msg)) {
                System.out.println("客户端数据发送完毕");
                socket.close();
                break;
            }
            byte[] bytes = msg.getBytes();
            //客户端发送的数据包，需要指明接收的服务端的IP地址以及端口
            DatagramPacket packet =
                    new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),8888);
            //发送数据包
            socket.send(packet);
        }



    }
}
