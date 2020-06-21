package forum;

import java.rmi.registry.*;
import java.io.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost");

        ServerInterface server = (ServerInterface)reg.lookup("ForumServer");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        do {
          System.out.println();
          System.out.println("l          ... list topics");
          System.out.println("l <topic>  ... list postings from <topic>");
          System.out.println("p <topic>  ... post a message to <topic>");
          System.out.println("q          ... quit");

          System.out.print("> ");
          line = br.readLine();

          String[] input = line.split(" ");

          if (input.length > 1) {
              if (input[0].equals("l")) {
                  Collection<String> postings = server.getPostings(input[1]);
                  for (String p : postings)
                      System.out.println(p);
              } else if (input[0].equals("p")) {
                  String topic = input[1];
                  System.out.println("Press enter twice to quit");

                  StringBuffer sb = new StringBuffer();
                  while (true) {
                      line = br.readLine();
                      if (line.length() == 0)
                          break;
                      sb.append(line);
                  }

                  server.post(topic, sb.toString());
              }
          } else if (input.length > 0) {
              if (input[0].equals("l")) {
                  Collection<String> topics = server.getTopics();
                  for (String t : topics)
                      System.out.println(t);
              } else if (input[0].equals("q")) {
                  System.exit(0);
              }
          }
      } while(true);
    }

}
