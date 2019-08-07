
package infrasoft;

import java.awt.*;
import java.io.File;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends Servico {
public Servidor() {}
public static void main(String args[]) {
	try {
		Servico obj= new Servico();
		Interface stub= (Interface) UnicastRemoteObject.exportObject(obj,0);
		
		Registry registry = LocateRegistry.getRegistry();
		
		registry.bind("Hello", stub);
		System.err.println("Server Ready");
	}
	catch (Exception e){
		System.err.println("Server exception: " + e.toString());
		e.printStackTrace();
		
	}
	
	
	
}
	
}
