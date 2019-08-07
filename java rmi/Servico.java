package infrasoft;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.*;

public class Servico implements Interface {

	
	public void writefile(String nome, byte[] dados, int tam) throws RemoteException { //aqui criamos o arquivo
		try {
			FileOutputStream arquivo = new FileOutputStream(nome);
			arquivo.write(dados, 0, tam);
			arquivo.flush();
			arquivo.close();
		} catch (Exception e) {
			System.out.println("Arquivo não pode ser criado");
		}

	}

	@Override
	public void openfile(String nome) throws RemoteException {
		try{java.awt.Desktop.getDesktop().open(new File(nome));
	}
		catch(Exception e) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	
	

}
