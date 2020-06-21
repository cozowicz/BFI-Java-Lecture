package rmi;

import java.rmi.*;
import java.util.*;

public interface ServerInterface extends Remote {
    // parameter typen muessen java.io.Serializable implementieren.
    public void login(String name, ClientInterface client) throws RemoteException;

    public void sendMsg(String meinName, String msg) throws RemoteException;

    public ArrayList<String> getUsers() throws RemoteException;
}
