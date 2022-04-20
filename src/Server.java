import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket server = new ServerSocket(9999);) {
			int clientcounter = 0;
			while (clientcounter <= 2) {
				clientcounter++;

				try (// defination server
						Socket client = server.accept(); // open connection between server and client
						InputStream clientsendtoserver = client.getInputStream();
						OutputStream serversendtoclient = client.getOutputStream();
						Reader clientinput = new InputStreamReader(clientsendtoserver);
						BufferedReader clientdata = new BufferedReader(clientinput);
						PrintStream serverdata = new PrintStream(serversendtoclient);) {
					ArrayList<String> inputtofile = new ArrayList<String>();
					String message = clientdata.readLine();
					inputtofile.add(message);
					serverdata.println("well come " + message);
					inputtofile.add("well come " + message);
					String line;
					int count = 0;
					while (count <= 5) {
						count++;
						line = clientdata.readLine();
						inputtofile.add(line);
						System.out.println(line);
					}
					File f = new File("C:\\Users\\Samy\\Desktop\\java\\naga.txt");
					PrintWriter insertdata = new PrintWriter(f);
					for (String line1 : inputtofile) {
						insertdata.println(line1);
					}
					insertdata.close();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
