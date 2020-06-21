package chat;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.io.*;

public class Client extends UnicastRemoteObject implements
  ClientInterface {

    public Client() throws RemoteException
    { }

    public void receiveMsg(String username, String msg) throws java.rmi.RemoteException {
        System.out.println(username +": " + msg);
    }

    public static void main(String[] args) throws Exception {

        // Hole Stub zur Registry vom anderen Rechner
        Registry reg = LocateRegistry.getRegistry("localhost");

        // Hole Stub des Chat Servers vom anderen Rechner
        ServerInterface srv =
                (ServerInterface)reg.lookup("ChatServer");

        Client c = new Client();
        ClientInterface stub = (ClientInterface)UnicastRemoteObject.toStub(c);

        srv.login(stub);

        // Rufe sendMsg() auf anderem Rechner auf
        // srv.sendMsg("Hallo");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        System.out.print("Username: ");
        String username = br.readLine();

        System.out.print("> ");
        while((line = br.readLine())!=null)
        {
            srv.sendMsg(username, line);
            System.out.print("> ");
        }
    }
}



