/**
 * 
 */
package voting;
import java.rmi.*;
import java.util.*;
/**
 * @author Clemens Klee<br>
 * Erstellt am 06.06.2006<br>
 * Version 1.0
 */
public interface ServerInterface extends Remote{
	
	public ArrayList<String> getQuestions() throws RemoteException;
	
	public ArrayList<Question> getStats() throws RemoteException;
	
	public void vote(String question, String answer) throws RemoteException;
}
