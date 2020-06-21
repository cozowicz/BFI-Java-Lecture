package socket;

import java.net.*;
import java.io.*;

public class SocketClient {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost",9580);

        PrintWriter pw = new PrintWriter(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        pw.println("Das ist toll");
        pw.flush();

        System.out.println("Msg: " + br.readLine());
        s.close();
    }
}
