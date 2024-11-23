import java.rmi.*;

public interface Multiplication extends Remote {
    public int mul(int x, int y) throws RemoteException;
}