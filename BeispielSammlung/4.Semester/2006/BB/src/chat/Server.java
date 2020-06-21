package chat;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

public class Server extends UnicastRemoteObject
        implements ServerInterface {

    private ArrayList<ClientInterface> clients = new ArrayList<ClientInterface>();

    public Server() throws RemoteException { }

    // Implementierung der Methode (wird vom ServerInterface verlangt)
    public void sendMsg(String username, String msg) throws RemoteException {
//         System.out.println(msg);

        for (ClientInterface c : clients) {
            try {
                c.receiveMsg(username, msg);
            }
            catch(RemoteException e)
            {}
        }
    }

    public void login(ClientInterface client) throws java.rmi.RemoteException {
        System.out.println("Neuer Client angemeldet");
        clients.add(client);
    }

    public void doWork(Server srv) {
        // ...
    }

    public static void main(String[] args) throws Exception {
        // Erzeugen der lokalen Registry
        Registry reg = LocateRegistry.createRegistry(1099);

        // Erzeugen unserer Server Implementierung
        ServerInterface srv = new Server();
        Server srv2 = new Server();

        // Registrieren des Servers in der Registry
        reg.bind("ChatServer", srv);

        System.out.println("Server ready");
    }
}
