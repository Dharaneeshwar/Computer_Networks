import java.io.*;
import java.util.*;

public class ARPTEST
{
     private static final String Command = "arp -a";
    
     public static void getARPTable(String cmd) throws Exception
     {  
          File fp = new File("ARPTable.txt");
          FileWriter fw = new FileWriter(fp);

          BufferedWriter bw = new BufferedWriter(fw);
         
          Process P = Runtime.getRuntime().exec(cmd);
          Scanner S = new Scanner(P.getInputStream()).useDelimiter("\\A");
          
          while(S.hasNext())
              bw.write(S.next());

          bw.close();
          fw.close();
     }
}