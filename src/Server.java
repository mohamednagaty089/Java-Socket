import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ServerSocket server=new ServerSocket(9090);
				Socket client=server.accept();
				InputStream clientsendtoserver=client.getInputStream();
				OutputStream serversendtoclient=client.getOutputStream();
				Reader clientinput=new InputStreamReader(clientsendtoserver);
				BufferedReader clientdata=new BufferedReader(clientinput);
				PrintStream serverdata=new PrintStream(serversendtoclient);){
			    
			String message=clientdata.readLine();
			serverdata.println("well come "+message);
			String line;
			int count=0;
			while(count<=5) {
				count++;
				line=clientdata.readLine();
				System.out.println(line);
			}
			
			    
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
