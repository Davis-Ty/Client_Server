/**
 * @author Tyon Davis
 * 
 */

package socket;

import java.net.*;

import java.io.*;
import java.util.Scanner;

public class client 
{

	public static void main(String[] args)throws IOException  
	{		//user input
			Scanner clientTalk = new Scanner(System.in);
			String talk;
			
			//setting connection points to null to make code simple at the end to close the connection when client types "END"
		    Socket server = null;
		    PrintWriter sendClientTalk = null;
		    BufferedReader serverResponce = null;
		    

		    try
		    {	//Officially setting connection point to server with client IP by name,port number that the server is on && marshaling/unmarshaling points
		    	InetAddress ip= InetAddress.getByName("localhost");
		    	server = new Socket(ip, 4999);
		    	sendClientTalk = new PrintWriter(server.getOutputStream(), true);
		    	serverResponce = new BufferedReader(new InputStreamReader(server.getInputStream()));
		    }
		    	catch (UnknownHostException e)
		    	{
		    		System.err.println("Can't find localhost.");
		    		clientTalk.close();
		    		return;
		    	}
		    		catch (IOException e)
		    		{
		    			System.err.println("IO Error on connection to localhost. Is server running?");
		    			clientTalk.close();
		    			return;
		      
		    		}		 
		    // do while loop keeps client connection open to write input until  "END" is typed
		    do
		    {
		    	System.out.print("Client: ");
		    	talk = clientTalk.nextLine();
		    	sendClientTalk.println(talk);
		    	System.out.println ("Server: " + serverResponce.readLine ());
		    }
		    	while (! talk.equals ("END"));

		    	sendClientTalk.close();
		    	clientTalk.close();
		    	serverResponce.close();
		    	server.close();
	}
}
	
