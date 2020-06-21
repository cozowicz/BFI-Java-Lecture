package voting;

public class Question implements java.io.Serializable {
    private String question;
    private int votes;

    public Question(String question) {
        this.question = question;
        this.votes = 0;
    }

    public String getQuestion() {
        return question;
    }

    public int getVotes() {
        return votes;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void vote() {
        this.votes++;
    }
}
