package voting;

import java.rmi.*;
import java.util.*;

public interface ServerInterface extends Remote {
    public Collection<String> getQuestions() throws RemoteException;

    public void vote(String question) throws RemoteException;

    public Collection<Question> getStats() throws RemoteException;
}
