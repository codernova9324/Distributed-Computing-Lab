import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) {
        try {
            Multiplication m1 = new MulRemote();
            Naming.rebind("rmi://localhost:5000/xyz", m1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}