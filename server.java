/**
 /**
 * @author Tyon Davis
 * 
 */

package socket;
import java.net.*;
import java.io.*;
public class server {
	public static void main(String[] args)throws IOException  {
		//setting serverSocket 4999
	ServerSocket serverSocket = new ServerSocket(4999);
		 //has a while loop set with a boolean for the server to loop for multiple clients
		 while(true) 
		 {
			 try 
			 {
				//accepting Socket "connection" && setting up the marshaling and unmarshaling  
			Socket clientConnection = serverSocket.accept ();
			BufferedReader clientResponce = new BufferedReader (new InputStreamReader (clientConnection.getInputStream ()));
			PrintWriter serverTalk = new PrintWriter (clientConnection.getOutputStream (), true);
				// making a new thread for the client connecting
				Thread t=new MultiClientHandler(clientConnection, serverTalk, clientResponce);
	        	t.start();			
			 }
			 	catch (Exception e)
        {			
			 		serverSocket.close();
			 		e.printStackTrace ();
        }
		 }																			}
					}
//creating a class, setting additional constraints with the modifier final && setting the Socket variable to private
class MultiClientHandler extends Thread
{
final BufferedReader clientResponce;
final PrintWriter serverTalk;
private Socket clientConnection;
//passing parameters to the class  
public MultiClientHandler(Socket clientConnection, PrintWriter serverTalk, BufferedReader clientResponce) 
{
	this.clientConnection=clientConnection;
	this.serverTalk=serverTalk;
	this.clientResponce=clientResponce;
}
//creating server response to to client that connected and typing
public void run() 
{
	String talkS="";
	String rev="";
	String rev2="";	
        	try
        	{
        		//setting client response to talkS and printing it in all caps
        		while (!rev2.equals("END")) 
        		{
        			talkS= clientResponce.readLine().toUpperCase();
        		//to reverse words
        		String [] revWord=talkS.split(" ");
        			for(int i=0;i<revWord.length;i++) 
        			{
        				rev2 =revWord[i]+" "+rev2;
        			}
        			//to reverse letters
        			for(int i = 0;i<talkS.length();i++) 
        			{	
        				rev=talkS.charAt(i)+rev;
        			}
        		//printing outputs
        		serverTalk.println(rev2+" || "+rev );
        		rev="";
        		rev2="";
        		}
        	}
        		catch (Exception e) 
        		{
        			this.serverTalk.close ();
        		}
        	try
	        {	
	        	this.clientResponce.close ();
	        	this.clientConnection.close ();
	        }
	        		catch (Exception e)
	        		{
	        			e.printStackTrace ();
	        		}
}
}				