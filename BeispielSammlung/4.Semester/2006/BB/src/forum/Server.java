package forum;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class Server extends UnicastRemoteObject implements ServerInterface {

    // topic -> Liste von Postings
    private HashMap<String, ArrayList<String>> topics = new HashMap<String,ArrayList<String>>();

    public Server() throws Exception
    { }

    // Liste der Themen
    public Collection<String> getTopics() throws RemoteException {
        return new ArrayList(topics.keySet());
    }

    // Liste der Postings
    public Collection<String> getPostings(String topic) throws RemoteException {
        return topics.get(topic);
    }

    // Neues Posting erstellen
    public void post(String topic, String posting) throws RemoteException {
        ArrayList<String> postings = topics.get(topic);

        if(postings == null) {
            postings = new ArrayList<String>();
            topics.put(topic, postings);
        }
        postings.add(posting);
    }

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("ForumServer", new Server());

        System.out.println("Forum Server Ready!");
    }
}
