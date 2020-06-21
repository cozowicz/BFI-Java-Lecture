package voting;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Collection;
import java.util.*;

public class Server extends UnicastRemoteObject implements ServerInterface {

    private HashMap<String, Question> questions = new HashMap<String, Question>();

    public Server(String filename) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while((line = br.readLine()) != null) {
            questions.put(line, new Question(line));
        }
        br.close();
    }

    public Collection<String> getQuestions() throws RemoteException {
        ArrayList<String> justTheStrings = new ArrayList<String>();
        for (Question q : questions.values()) {
            justTheStrings.add(q.getQuestion());
        }
        return justTheStrings;
    }

    public void vote(String question) throws RemoteException {
        questions.get(question).vote();
    }

    public Collection<Question> getStats() throws RemoteException {
        // the values() list returned from the HashMap isn't serializable, thus we need to
        // create a ArrayList()
        return new ArrayList(questions.values());
    }

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("VoteServer", new Server("questions.txt"));
    }
}
