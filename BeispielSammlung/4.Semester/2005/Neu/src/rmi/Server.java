package rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class Server extends UnicastRemoteObject implements ServerInterface {

    private ArrayList<User> users = new ArrayList<User>();

    private class User {
        public String name;
        public ClientInterface client;

        User(String name, ClientInterface c) {
            this.name = name;
            this.client = c;
        }
    }

    public Server() throws RemoteException
    {
    }

    public void login(String name, ClientInterface client) throws RemoteException {
        System.out.println("Anmeldung von " + name);
        synchronized(users)
        {
            users.add(new User(name, client));
        }
    }

    public void sendMsg(String meinName, String msg) throws RemoteException {

        // make sure only 1 thread at a time can change users
        synchronized(users)
        {
            ArrayList<User> failures = new ArrayList<User>();

            for (User u : users) {
                try {
                    u.client.receiveMsg(meinName, msg);
                } catch (RemoteException ex) {
                    // If an error happens with one client, still send the msg to the others
                    failures.add(u);
                }
            }

            // remove those that caused an error
            users.removeAll(failures);
        }
    }

    public ArrayList<String> getUsers() throws RemoteException {
        ArrayList<String> names = new ArrayList<String>();

        synchronized(users)
        {
            for (User u : users)
                names.add(u.name);
        }
        return names;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Starting server...");
        Registry reg = LocateRegistry.createRegistry(1099);

        Server s = new Server();

        reg.bind("ChatServer",s);
        System.out.println("started.");
    }
}
