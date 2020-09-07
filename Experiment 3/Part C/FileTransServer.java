import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class FileTransServer {

 public static void main(String[] args) throws Exception {
 ServerSocket sock = new ServerSocket(5000);
 Socket socket = sock.accept();

 InetAddress IA = InetAddress.getByName("localhost");
 
 //Specify the file
 File file = new File("D:\\Dharaneeshwar\\Lab Programs\\CN\\3\\c\\data.txt");
 FileInputStream fis = new FileInputStream(file);
 BufferedInputStream bis = new BufferedInputStream(fis);

 //Get socket's output stream
 OutputStream os = socket.getOutputStream();

 //Read File Contents into contents array
 byte[] contents;
 long fileLength = file.length();
 long current = 0;

 long start = System.nanoTime();
 while(current!=fileLength){
 int size = 10000;
 if(fileLength - current >= size)
 current += size;
 else{
 size = (int)(fileLength - current);
 current = fileLength;
 }
 contents = new byte[size];
 bis.read(contents, 0, size);
 os.write(contents);
 System.out.print("Sending file ... "+(current*100)/fileLength+"% complete!");
 }

 os.flush();
 socket.close();
 sock.close();
 System.out.println("File sent succesfully!");
 }
}
