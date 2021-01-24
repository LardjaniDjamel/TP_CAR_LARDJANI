package ftp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FtpThread extends Thread {
	
	private Socket sock;
	private ServerSocket server; 
	private String pass = "pass"; 
	private DataOutputStream dataOut;
	private int port;
	private String currentDir; 

	
	public FtpThread(Socket s, ServerSocket server, int p){
		this.sock = s;
		this.server = server;
		this.port = p;
	}
	
	public void run(){
		try {

			// Input from client
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			PrintStream output = new PrintStream(this.sock.getOutputStream());
			
			// Output to client
			this.dataOut = new DataOutputStream(output);
			dataOut.writeBytes("220  Service ready for new user\r\n");
			
			Path currentRelativePath = Paths.get(".");
			this.currentDir= currentRelativePath.toAbsolutePath().toString();

			String res = "";
			while(!res.equals("QUIT")){
				
				System.out.println("Waiting for command  ");
				String data = buffRead.readLine();
				if(data!=null){
					System.out.println("Command receive : " + data);
					res = this.CommandRequest(data);
					
					this.dataOut.writeBytes(res + "\r\n");
				}
				else{
					res = "QUIT";
					dataOut.writeBytes("221 "+res + "\r\n");
				}
				
			}
			this.sock.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Check request receive and treat them
	 * @param request cmd and arguments
	 * @return
	 * @throws IOException 
	 */
	public String CommandRequest(String request) throws IOException{
		String[] data = request.split(" ");
		String res ="";
		String cmd = data[0];
		
		if(cmd.equals("USER")){
			for(String d : data){
				System.out.println("Data " + d);
			}
			res = this.User(data[1]);
        }
        else if(cmd.equals("PASS")){
			res =this.Pass(data[1]);
		}
		
		else if(cmd.equals("QUIT")){

			res =this.Quit(data[0]);
		}
		
		else{
			res = "500 Wrong command";
		}
		return res;
	}
	

	/**
	 * check username, send 200 if ok 
	 * @param data
	 * @return
	 */
	
	public String User(String data){
		return "331 " + data; 
		
	} 	
	
	/**
	 * Check password, send 200 if ok 
	 * @param data
	 * @return
	 */
	public String Pass(String data){
		if(data.equals(this.pass)){
			return "230 Logged in"; 
		}
		return "500 Wrong user/password";
	}
	

	
	
	/**
	 * Quit ftp server
	 * @param data
	 * @return
	 */
	public String Quit(String data){
		return "221 QUIT"; 
	}
	

	

}
