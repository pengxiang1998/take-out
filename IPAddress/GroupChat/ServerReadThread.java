package IPAddress.GroupChat;

import java.io.*;
import java.net.Socket;

public class ServerReadThread extends Thread{
    private Socket socket;
    public ServerReadThread(Socket accept) {
        this.socket=accept;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            //将原始的字节输入流包装成高级的数据输入流
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println(socket.getInetAddress()+"客户端上线了哟！");//输出发送客户端的IP地址
            //使用数据输入流读取客户端发送的数据
            while (true) {
                try {
                    String string = dataInputStream.readUTF();//通信很严格，要保持一致
                    System.out.println(string);
                    sendMsg(string);
                } catch (IOException e) {
                    System.out.println(socket.getInetAddress()+"客户端下线了！");
                    Server.sockets.remove(socket);
                    dataInputStream.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("服务异常！" + socket.getInetAddress() + "连接中断！");
        }
    }

    private void sendMsg(String string) throws IOException {
        //发送给所有Socket管道去接收
        System.out.println("转发数据");
        for (Socket online:Server.sockets) {
            OutputStream outputStream = online.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();
        }
    }
}
