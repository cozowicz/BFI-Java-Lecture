package rmi;

import java.rmi.*;

public interface ClientInterface extends Remote {
    public void receiveMsg(String name, String msg) throws RemoteException;
}
