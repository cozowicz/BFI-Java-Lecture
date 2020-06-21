/**
 * 
 */
package voting;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.io.*;

/**
 * @author Clemens Klee<br>
 * Erstellt am 06.06.2006<br>
 * Version 1.0
 */
public class Server extends UnicastRemoteObject implements ServerInterface{
	private HashMap<String, Question> fragen;
	
	public Server(String questionFile) throws Exception{
		fragen = new HashMap<String, Question>();
		
		BufferedReader in = new BufferedReader(new FileReader(questionFile));
		String line = in.readLine();
		while(line != null){
			fragen.put(line,new Question(line));
			line = in.readLine();
		}
		in.close();
	}
	
	public ArrayList<String> getQuestions() throws RemoteException {
		return new ArrayList<String>(fragen.keySet());
	}


	public ArrayList<Question> getStats() throws RemoteException {
		return new ArrayList<Question>(fragen.values());
	}


	public void vote(String question, String answer) throws RemoteException {
		fragen.get(question).vote(answer);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception{
		Registry reg = LocateRegistry.createRegistry(1099);
		Server s = new Server("Fragen.txt");
		reg.bind("VoteServer",s);
		System.out.println("VoteServer ready...");
	}
}
