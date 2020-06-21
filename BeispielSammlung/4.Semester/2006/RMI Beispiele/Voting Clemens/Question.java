/**
 * 
 */
package voting;

import java.io.Serializable;

/**
 * @author Clemens Klee<br>
 * Erstellt am 06.06.2006<br>
 * Version 1.0
 */
public class Question implements Serializable{
	private String question;
	private int yesVotes = 0;
	private int noVotes = 0;
	
	public Question(String question){
		this.question = question;
	}
	/**
	 * @return Returns the noVotes.
	 */
	public int getNoVotes() {
		return noVotes;
	}
	/**
	 * @param noVotes The noVotes to set.
	 */
	public void setNoVotes(int noVotes) {
		this.noVotes = noVotes;
	}
	/**
	 * @return Returns the question.
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question The question to set.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return Returns the yesVotes.
	 */
	public int getYesVotes() {
		return yesVotes;
	}
	/**
	 * @param yesVotes The yesVotes to set.
	 */
	public void setYesVotes(int yesVotes) {
		this.yesVotes = yesVotes;
	}
	
	public void vote(String answer){
		if(answer.equalsIgnoreCase("Ja"))
			yesVotes++;
		else
			noVotes++;
	}
	
	
}
