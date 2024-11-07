import java.rmi.*;

public class Client {
    public static void main(String args[]) {
        try {
            Multiplication m1 = (Multiplication) Naming.lookup("rmi://localhost:5000/xyz");
            System.out.println(m1.mul(4, 3));
        } catch (Exception e) {
        }
    }
}
