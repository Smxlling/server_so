package controller;
import model.*;

import model.Server;

public class RunServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server miServidor=new Server();
		Thread hilo = new Thread(miServidor);
		hilo.start();
		
	}

}
