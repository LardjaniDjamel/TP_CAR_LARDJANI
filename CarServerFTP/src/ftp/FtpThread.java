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
	private String user = "djamel";
	private DataOutputStream dataOut;
	private PrintStream output;
	private BufferedReader buffRead;
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
			this.buffRead = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			this.output = new PrintStream(this.sock.getOutputStream());
			
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
		switch (cmd) {
		case "USER":
			for(String d : data){
				System.out.println("Data " + d);
			}
			res = this.User(data[1]);
		
			break;
		case "PASS":
			res =this.Pass(data[1]);
			break;
		case "DIR":
			this.dir(data[1]);			
			break;
		case "PWD":
			res = this.PWD();
			break;
		case "RETR":
			res =this.RETR(data[1]);
			break;
		case "STOR":
			res =this.STOR(data[1]);
			break;
		case "QUIT":
			res =this.Quit(data[0]);
			break;

		default:
			res = "500 Syntax error ";
		}
		
		return res ;
		
	}
		

       
       
	

	/**
	 * check username, send 200 if ok 
	 * @param data
	 * @return
	 */
	
	public String User(String data){
	
		if(data.equals(this.user)){
			return("331 User name success, please put your password");
		}
		return "500 Wrong user/password";
		
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
	 * transfer a copy of the file, specified in the pathname
	 * @param copy 
	 * @return
	 */
	public String RETR(String copy){
		return "202 copied";
	}
	
	
	/**
	 * accept the data transferred via the data connection and to store the data as
     * 	a file at the server site
	 * @param copy
	 * @return
	 */
	public String STOR(String data){
		return "202 stored";
	}
	
	
	

	
	
	/**
	 * Quit ftp server
	 * @param data
	 * @return
	 */
	public String Quit(String data){
		return "221 QUIT"; 
	}
	
	
	/**
	 * check the value of the current directory
	 * @return
	 */
	public String PWD(){
		
		return "257 " +this.currentDir;
	}
	
	/**
	 * Get a list of the given directory
	 * @param data  path to the directory to list
	 * @throws IOException 
	 */
	public void dir(String path) throws IOException
	{
		if (sock.isClosed() || sock== null) {
			try {
				this.server = new ServerSocket(port);
				this.sock = this.server.accept();
				this.output = new PrintStream(this.sock.getOutputStream());
				this.dataOut = new DataOutputStream(output);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		String filename = this.currentDir;
		if (path != null)
        {
            filename = filename + "/" + path;
        }


		
	}
	
	

}
