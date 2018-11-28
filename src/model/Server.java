package model;
import java.net.*;
import java.io.*;
public class Server implements Runnable{
	private Socket miSocket;
	public static void main(String[] args){
		Server miServidor=new Server();
		Thread hilo = new Thread(miServidor);
		hilo.start();
		
	}
			
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Esperando");
		ServerSocket miServer;
		
		PaqueteInformacion recivido=new PaqueteInformacion();
		try {
			miServer = new ServerSocket(8888);
			while(true){
				miSocket=miServer.accept();
				InetAddress iSo= miSocket.getInetAddress();
				
				String ipPropia=iSo.getHostAddress();
				System.out.println("Conectado :"+ipPropia);
				ObjectInputStream ois=new ObjectInputStream(miSocket.getInputStream());
				
				
				try {
					recivido=(PaqueteInformacion) ois.readObject();
					System.out.println("Mensaje: "+recivido.getMensaje());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("NO se encontro la clase");;
				}
				
				ois.close();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
