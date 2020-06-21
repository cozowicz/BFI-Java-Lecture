package rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.*;
import java.util.*;

public class Client extends UnicastRemoteObject implements ClientInterface {

    public Client() throws RemoteException { }

    public void receiveMsg(String name, String msg) throws RemoteException {
        System.out.println(name + ": " + msg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Starting...");
        // Registry reg = LocateRegistry.getRegistry("172.17.0.220",1099);
        Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
System.out.println("got registry");
        ServerInterface server = (ServerInterface)reg.lookup("ChatServer");

System.out.println("got server");
        Client c = new Client();
        ClientInterface stub = (ClientInterface)UnicastRemoteObject.toStub(c);

        ArrayList<String> users = server.getUsers();
        for (String name : users) {
            System.out.println("Online: " + name);
        }

        server.login("Markus", stub);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.print("# ");
        while((line = br.readLine()) != null) {
            server.sendMsg("Markus", line);
            System.out.print("# ");
        }

    }
}
