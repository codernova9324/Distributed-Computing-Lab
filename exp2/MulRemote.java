import java.rmi.*;
import java.rmi.server.*;

public class MulRemote extends UnicastRemoteObject implements Multiplication {
    MulRemote() throws RemoteException {
        super();
    }

    public int mul(int x, int y) {
        return x * y;
    }
}