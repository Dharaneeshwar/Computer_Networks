import java.io.*;
import java.util.*;

class RARP {
    public static void main(String args[]) {
        try {
            Process p = Runtime.getRuntime().exec("arp -a");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str, str1 = "", st1, st2;
            while ((str = br.readLine()) != null)
                str1 += str + "\n";
            StringTokenizer st = new StringTokenizer(str1, "\n");
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the physical 48-bit ADDR ENTER THE PHYSICAL 48BIT ADDRESS ");
            st2 = br1.readLine();
            while (st.hasMoreTokens()) {
                st1 = st.nextToken();
                if (st1.indexOf(st2) != -1)
                    System.out.println(st1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// SIMPLE :
// enter the MAC ADDRESS
// Press enter
// IP address will be printed 

// Note :
// if you are not able to figure out your MAC address then open CMD type "arp -a" you will get a list of IPs and their corresponding MAC address
// Enter one of the MAC address from that
// Corresponding IP address will be printed in the console

// PC : What I have said in the "Note" is the exact thing the above CODE does 😂