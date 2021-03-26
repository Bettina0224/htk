package ht.tcp.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPSzerverNaplo {
	private final static Logger Logger = java.util.logging.Logger.getLogger(TCPSzerverNaplo.class.getName());
	
	private Socket socket;

	public TCPSzerverNaplo(Socket socket) {
		this.socket = socket;
	}

	private void work() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String message = input.readLine();
				if (message == null)
					break;
				Logger.log(Level.INFO, message);

			}

			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		Thread worker = new Thread(new Runnable() {
			@Override
			public void run() {
				TCPSzerverNaplo.this.work();

			}

		});
		worker.start();
	}

}
