import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader fromServer = null, fromUser = null;
        PrintWriter toServer = null;
        Socket sock = null;
        try {
            if (args.length == 0)
                sock = new Socket(InetAddress.getLocalHost(), 4000);
            else
                sock = new Socket(InetAddress.getByName(args[0]), 4000);
            fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));
            toServer = new PrintWriter(sock.getOutputStream(), true);
            String Usrmsg, Srvmsg;
            System.out.println("Type \"over\" to quit");
            while (true) {
                System.out.print("Enter msg to server : ");
                Usrmsg = fromUser.readLine();
                if (Usrmsg == null || Usrmsg.equals("over")) {
                    toServer.println("over");
                    break;
                } else
                    toServer.println(Usrmsg);
                Srvmsg = fromServer.readLine();
                System.out.println(Srvmsg);
            }
            fromUser.close();
            fromServer.close();
            toServer.close();
            sock.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
