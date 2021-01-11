import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @author lardjani
 *
 */
public class TCPConnexion {
	
	  final static int port = 9632;


	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 try {
		      ServerSocket socketServeur = new ServerSocket(port);
		      System.out.println("Lancement du serveur");

		      while (true) 
		      {
		        Socket socketClient = socketServeur.accept();
		        String message = "";

		        System.out.println("Connexion avec : "+socketClient.getInetAddress());

		        // InputStream in = socketClient.getInputStream();
		        // OutputStream out = socketClient.getOutputStream();

		        BufferedReader in = new BufferedReader(
		          new InputStreamReader(socketClient.getInputStream()));
		        PrintStream out = new PrintStream(socketClient.getOutputStream());
		        message = in.readLine();
		        out.println(message);

		        socketClient.close();
		      }
		    } 
		 catch (Exception e) 
		 	{
		      e.printStackTrace();
		    }
	}
}


