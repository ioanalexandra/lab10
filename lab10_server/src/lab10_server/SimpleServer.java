package lab10_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	 // Definim portul la care asculta serverul
	 public static final int PORT = 8100;
	 public SimpleServer() throws IOException {
	 ServerSocket serverSocket = null ;
	 try {
	 serverSocket = new ServerSocket(PORT);
	 while (true) {
	 System.out.println ("Waiting for a client ...");
	 Socket socket = serverSocket.accept();
	 // Execut requestul de la client intr-un thread separat
	 new ClientThread(socket).start();
	 }
	 } catch (IOException e) {
	 System.err. println ("Ooops... " + e);
	 } finally {
	 serverSocket.close();
	 }
	 }
	 public static void main ( String [] args ) throws IOException {
	 SimpleServer server = new SimpleServer ();
	 }
	}
