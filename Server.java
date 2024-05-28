import java.io.*;  
import java.net.*;
import java.util.ArrayList;

/**
* The Server class helps the two clients to perform the tic-tac-toe game. 
* It  connects the clients and allows exchange of information
* @author  Zaria Wong
* @version 1.0
* @since   5/10/2023
*/

public class Server {
	ServerSocket serverSock;
	/**
	  * An arraylist "writers" is created to store the printwriters
	 */
	ArrayList<PrintWriter> writers = new ArrayList<PrintWriter>();
	int numberofclients=0;
	
	/**
	  * Our main method which implements the server
	  * @param args The command line arguments.
	 */
	public static void main(String[] args) {  
		Server server = new Server();  
		server.go();
	}

	/**
	  * The method to connect server and clients by threads.
	 */
	public void go() {  
		try {
			serverSock = new ServerSocket(5000);
			System.out.println("Server is running...");

			while (true) {
				Socket sock= serverSock.accept();
				numberofclients+=1;
				System.out.println("Server is connected to client"+numberofclients);
			
				ClientHandler clientHandler = new ClientHandler(sock);

				Thread clientThread1 = new Thread(clientHandler);
				Thread clientThread2 = new Thread(clientHandler);
				clientThread1.start();
				clientThread2.start();
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
		}
	} 
	
	/**
	* The ClientHandler class implements Runnable interface. 
	* It helps handle messages between clients.
	*/
	class ClientHandler implements Runnable{
		private Socket sock;
		/**
		* It is a method to connect client handler with sock.
		* @param sock The sock to be connected.
		*/
		public ClientHandler(Socket sock) {
			this.sock = sock;
		}
		@Override
		/**
		* It is a method to send and receive messages from client.
		*/
		public void run() {
			try {
				PrintWriter writer = new PrintWriter(sock.getOutputStream(), true);  
				writers.add(writer);
				
				InputStreamReader streamReader = new InputStreamReader (sock.getInputStream());  
				BufferedReader reader = new BufferedReader(streamReader); 
				
				String command;
				
				while ((command = reader.readLine()) != null) {
					System.out.println("Command from client: " + command);
					
					if (command.startsWith("BREAKPlayer1")) {
						for (PrintWriter eachWriter: writers) {
							System.out.println("BREAKPlayer1");
							eachWriter.println("BREAKPlayer1");
						}
					}
					if (command.startsWith("BREAKPlayer2")) {
						for (PrintWriter eachWriter: writers) {
							System.out.println("BREAKPlayer2");
							eachWriter.println("BREAKPlayer2");
						}
					}

					if (command.startsWith("CLIENT2 CONNECTED")) {
						for (PrintWriter eachWriter: writers) {
							eachWriter.println("CLIENT2 CONNECTED");
						}
					}

					if (command.startsWith("POneWin")) {
						for (PrintWriter eachWriter: writers) {
							eachWriter.println(command);
						}
					}
					
					if (command.startsWith("PTwoWin")) {
						for (PrintWriter eachWriter: writers) {
							eachWriter.println(command);
						}
					}
					
					if (command.startsWith("POnebutton")) {
						for (PrintWriter eachWriter: writers) {
							eachWriter.println(command);
						}
					}
					
					if (command.startsWith("PTwobutton")) {
						for (PrintWriter eachWriter: writers) {
							eachWriter.println(command);
						}
					}				
				}				
			} catch (Exception ex) {		
				ex.printStackTrace();
			} finally {
				/**
				* Send the message to the client if another client left.
				*/
				for (PrintWriter eachWriter: writers) {
					System.out.println("BREAKPlayer");
					eachWriter.println("BREAKPlayer");
				}
			}
		}
	}
}