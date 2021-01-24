package ftp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	 public Server(int port) throws IOException, InterruptedException
	    { 
			ServerSocket s = new ServerSocket(port);
			System.out.println("Starting Server on port : " + port  );
			while(true){
				Socket sock = s.accept();
				System.out.println("Un client vient de se connecter ");
				FtpThread th = new FtpThread(sock, s, port);
				th.start();
	    }
	    }

}
