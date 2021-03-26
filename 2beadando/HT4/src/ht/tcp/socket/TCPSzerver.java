package ht.tcp.socket;

// TCPServer.java
import java.net.*;
import java.io.*;

public class TCPSzerver {
	public static void main(String args[]) {

		int port;
		ServerSocket server_socket;
		BufferedReader input;

		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("port = 1500 (default)");
			port = 1500;
		}

		try {

			server_socket = new ServerSocket(port);
			System.out.println("Szerver varakozik a kliensre port:" + server_socket.getLocalPort());

			// szervert egy vegtelen ciklusban elinditjuk
			while (true) {
				Socket socket = server_socket.accept();
				System.out.println("Uj kapcsolat elfogadva " + socket.getInetAddress() + ":" + socket.getPort());
				TCPSzerverNaplo naplo = new TCPSzerverNaplo(socket);
				naplo.execute();

			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}