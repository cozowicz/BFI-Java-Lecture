package voting;

import java.rmi.registry.*;
import java.io.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost");

        ServerInterface server = (ServerInterface)reg.lookup("VoteServer");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        do {
          System.out.println();
          System.out.println("l          ... list questions");
          System.out.println("s          ... statistics");
          System.out.println("v <number> ... vote for question <number>");
          System.out.println("q          ... quit");

          System.out.print("> ");
          line = br.readLine();

          if(line.equals("l")) {
              Collection<String> questions = server.getQuestions();
              int i = 1;
              for (String q : questions) {
                  System.out.println(i+". "+q);
                  i++;
              }
          }
          else if(line.equals("s")) {
              Collection<Question> questions = server.getStats();
              int votes = 0;
              for (Question q : questions) {
                  votes += q.getVotes();
              }
              for (Question q : questions) {
                  if(votes == 0)
                      System.out.println(q.getVotes() + " (0%) " + q.getQuestion());
                  else
                      System.out.println(q.getVotes() + " ("+(q.getVotes()*100/votes)+"%) " + q.getQuestion());
              }
          }
          else if(line.split(" ")[0].equals("v")) {
              int question = Integer.parseInt(line.split(" ")[1])-1;
              Collection<String> questions = server.getQuestions();
              for (String q : questions) {
                  if(question == 0) {
                      server.vote(q);
                      break;
                  }
                  question--;
              }
          }
          else if(line.equals("q")) {
              System.exit(0);
          }
      } while(true);
    }

}
