package chat;

public interface ClientInterface extends java.rmi.Remote {
    public void receiveMsg(String username, String msg) throws java.rmi.RemoteException;
}
