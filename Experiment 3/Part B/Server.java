import java.io.*;
import java.net.*;

class chatServer {
    public static int clientport = 8040, serverport = 8050;

 public static void main(String args[]) throws Exception {
 DatagramSocket SrvSoc = new DatagramSocket(clientport);
 byte[] SData = new byte[1024];
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Server Ready");
 while (true) {
 byte[] RData = new byte[1024];
 DatagramPacket RPack = new DatagramPacket(RData , RData.length);
 SrvSoc.receive(RPack);
 String Text = new String(RPack.getData());
 if (Text.trim().length() == 0)
 break;
 System.out.println("\nFrom Client <<< " + Text);
 System.out.print("Msg to Client : ");
 String srvmsg = br.readLine();
 InetAddress IPAddr = RPack.getAddress();
 SData = srvmsg.getBytes();
 DatagramPacket SPack = new DatagramPacket(SData,SData.length,IPAddr,
 serverport);
 SrvSoc.send(SPack);
 }
 System.out.println("\nClient Quits\n");
 SrvSoc.close();
 }
}
