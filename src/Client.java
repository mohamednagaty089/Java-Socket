
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.RMIClientSocketFactory;
import java.util.Scanner;

public class Client {
public static void main(String args[])   {
	
	try(Socket server=new Socket("10.10.0.81",9090);
			InputStream fromserver=server.getInputStream();
			OutputStream clientoutput=server.getOutputStream();
			Reader input=new InputStreamReader(fromserver);
			BufferedReader serversend=new BufferedReader(input);
			PrintStream clientsend=new PrintStream(clientoutput);
			){
	    Scanner keyboardinput=new Scanner(System.in);
	    
		clientsend.println("mohamed nagaty badawy");
	     System.out.println(serversend.readLine());
	     String message="";
	     int count=1;
	     while(count<=5) {
	    	 count++;
           message=keyboardinput.nextLine();
           clientsend.println(message);              
	     }
	     
		
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
}
}