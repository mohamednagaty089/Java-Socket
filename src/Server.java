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
		try (ServerSocket server = new ServerSocket(9910);) {

			while (true) {

				Socket client = server.accept();//whitout trywith resource so server not close socket after one client exit
					SocketHandler sockethandler = new SocketHandler(client);
					sockethandler.start();

			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
