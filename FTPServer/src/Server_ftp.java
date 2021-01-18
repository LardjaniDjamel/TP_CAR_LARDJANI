import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server_ftp extends Thread{
	
	private Socket client;

    public Server_ftp(Socket c){
        this.client=c;
    }

    @Override
	public void run() {
		try {
			Socket sock = this.client;
			while (true) {
				System.out.println("entrez votre login");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
                String login = in.readLine();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
