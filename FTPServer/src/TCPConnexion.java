import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
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
	

	  final static int port = 8001;
	  final static String login = "root";
	  final static String mdp ="root";



	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 try {
		      ServerSocket socketServeur = new ServerSocket(port);
		      System.out.println("Lancement du serveur sur le port "+ port);
		      InetAddress monAdresse = InetAddress.getLocalHost();
		     // System.out.println(monAdresse.getHostName());
		      //System.out.println(monAdresse.getHostAddress());
		      System.out.println(socketServeur.getInetAddress());

		      while (true) 
		      {
		    	// le serveur est à l'écoute
		    	  
		        Socket socketClient = socketServeur.accept();
		        //String message = "";

		       // System.out.println("Connexion avec : "+socketClient.getInetAddress());

		        //BufferedReader in = new BufferedReader( new InputStreamReader(socketClient.getInputStream()));
		        //PrintStream out = new PrintStream(socketClient.getOutputStream());
		        //message = in.readLine();
		        //out.println(message);
		        Thread t =new Server_ftp(socketClient);
	            t.start();
		        socketClient.close();
		      }
		    } 
		 catch (Exception e) 
		 	{
		      e.printStackTrace();
		    }
	}
}

