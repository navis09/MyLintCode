package others;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.*;

public class NetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("[fc00::1000:6d50:0]");
            System.out.println(address.isReachable(2000));

            System.out.println("User method 'isReachable': " + isReachable("10.0.109.80:32793"));
            System.out.println("User method 'isReachable': " + isReachable("10.0.109.80"));
            System.out.println("User method 'isReachable': " + isReachable("[fc00::1000:6d50:0]:32793"));
            System.out.println("User method 'isReachable': " + isReachable("[fc00::1000:6d50:0]:32755"));
            System.out.println("User method 'isReachable': " + isReachable("[fc00::1000:6d50:0]:32745"));
            System.out.println("User method 'isReachable': " + isReachable("[fc00d50:0]:32793"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isReachable(String hostNPort) throws Exception {
        int index = hostNPort.lastIndexOf(":");
        if (index < 0) {
            throw new Exception("该地址不符合'地址:端口'的格式");
        }
        String address = hostNPort.substring(0, index);
        int port = Integer.parseInt(hostNPort.substring(index + 1));
        try {
            new Socket(address, port).close();
            return true;
        } catch (IOException e) {
            // 异常即为地址不可用，不处理，直接返回false
        }
        return false;
    }

}
