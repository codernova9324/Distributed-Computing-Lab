import java.io.*;
import java.net.*;
import java.util.*;

class NameRes {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String url;
        try {
            System.out.println("Enter Host Name:");
            url = sc.next();
            InetAddress ip = InetAddress.getByName(url);
            System.out.println("IP Adress:" + ip.getHostAddress());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}