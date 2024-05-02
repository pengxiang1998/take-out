package IPAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) throws Exception {
        //获取本机IP地址对象的地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        //获取指定IP域名的IP地址对象
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
        //判断6秒内能否与百度联通，相当于ping
        System.out.println(ip.isReachable(6000));

    }
}
