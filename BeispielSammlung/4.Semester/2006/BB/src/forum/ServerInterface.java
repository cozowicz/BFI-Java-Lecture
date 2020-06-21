package forum;

import java.rmi.*;
import java.util.*;

public interface ServerInterface extends Remote {
    // Liste der Themen
    public Collection<String> getTopics() throws RemoteException;

    // Liste der Postings
    public Collection<String> getPostings(String topic) throws RemoteException;

    // Neues Posting erstellen
    public void post(String topic, String posting) throws RemoteException;
}
