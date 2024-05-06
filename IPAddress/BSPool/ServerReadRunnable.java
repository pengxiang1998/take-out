package IPAddress.BSPool;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReadRunnable implements Runnable{
    private Socket socket;
    public ServerReadRunnable(Socket accept) {
        this.socket=accept;
    }

    @Override
    public void run() {
        try {
            System.out.println("上线访问了");
            OutputStream outputStream = socket.getOutputStream();
            //将原始的字节输出流包装成高级的打印流
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("HTTP/1.1 200 OK");
            printStream.println("Content-Type:text/html;charset=UTF-8");
            printStream.println();
            printStream.println("<div style='color:red;font-size:40px;text-align:center'>服务端响应</div>");
            printStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("服务异常！" + socket.getInetAddress() + "连接中断！");
        }
    }
}
