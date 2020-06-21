package socket;

import java.net.*;
import java.io.*;

public class QuoteServer {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(9580);

        Socket client = socket.accept();

        System.out.println("Connection from " + client.getInetAddress() );

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter pw = new PrintWriter(client.getOutputStream());

        String line = br.readLine();
        System.out.println("Client msg: " + line);

        pw.println("Message of the day: " + line);
        pw.flush();

        br.readLine();
        client.close();
    }
}
