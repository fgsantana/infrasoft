package infrasoft;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.*;

public interface Interface extends Remote {
	void writefile(String nome, byte[] dados, int tam) throws RemoteException;

	void openfile(String nome) throws RemoteException;
}
