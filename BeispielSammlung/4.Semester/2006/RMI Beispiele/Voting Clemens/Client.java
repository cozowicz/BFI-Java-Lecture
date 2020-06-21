/**
 * 
 */
package voting;
import java.util.*;
import java.io.*;
import java.rmi.registry.*;
/**
 * @author Clemens Klee<br>
 * Erstellt am 06.06.2006<br>
 * Version 1.0
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception{
		Registry reg = LocateRegistry.getRegistry("localhost",1099);
		ServerInterface server = (ServerInterface)reg.lookup("VoteServer");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while(true){
			System.out.println("l         ...listet die Fragen");
			System.out.println("s         ...zeigt Statistik");
			System.out.println("v <Frage> ...zu einer Frage abstimmen");
			System.out.println("q         ...beenden");
			
			System.out.print("> ");
			
			line = in.readLine();
			String[] input = line.split(" ");
			if(input[0].equalsIgnoreCase("l")){
				ArrayList<String> fragen = server.getQuestions();
				
				int i = 1;
				for(String s : fragen){
					System.out.println(i + ". " + s);
					i++;
				}
				System.out.println();
			}
			else if(input[0].equalsIgnoreCase("s")){
				ArrayList<Question> fragen = server.getStats();
				for(Question q : fragen){
					int voteges = q.getNoVotes()+q.getYesVotes();
					if(voteges > 0){
						float prozYes = ((float)q.getYesVotes()/voteges)*100;
						float prozNo = ((float)q.getNoVotes()/voteges)*100;
					
						System.out.println("Für \""+q.getQuestion()+"\" haben "
							+ prozYes + "% der Leute mit Ja und "+ prozNo +
							"% der Leute mit Nein abgestimmt.");	
					}
					else{
						System.out.println("Für \""+q.getQuestion()+"\" hat noch niemand abgestimmt.");
					}
				}
				System.out.println();
			}
			else if(input[0].equalsIgnoreCase("q")){
				System.exit(0);
			}
			else{
				ArrayList<String> questions = server.getQuestions();
				int index = Integer.parseInt(input[1]);
				/*
				StringBuffer buffer = new StringBuffer();
				for(int i = 1;i<input.length;i++){
					buffer.append(input[i]);
					buffer.append(" ");
				} */
				System.out.print("Geben Sie Ihre Antwort ein (Ja/Nein): ");
				line = in.readLine();
				// String question = buffer.toString().trim();
				String question = questions.get(index);
				server.vote(question,line);
				System.out.println();
			}
		}
	}

}
