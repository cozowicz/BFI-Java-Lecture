package chat;

// Schnittstelle des Servers
public interface ServerInterface extends java.rmi.Remote {

    // Alle Parameter muessen java.io.Serializable implementieren
    public void sendMsg(String username, String msg) throws java.rmi.RemoteException;

    public void login(ClientInterface client) throws java.rmi.RemoteException;
}
