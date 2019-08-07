package infrasoft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java.util.*;
import java.io.FileInputStream;
import java.rmi.*;

public class Cliente {
	private Cliente() {
	}

	public static void main(String[] args) {
			try {
				Scanner in = new Scanner(System.in);
				Registry registry = LocateRegistry.getRegistry(null);
				Interface stub = (Interface) registry.lookup("Hello");

				String command = ""; //recebe o comando, e se for write, vamos escrever o arquivo no metodo writefile na interface
				
				if (command.equals("write")) {
				String entrada = in.nextLine();
				Writer writer = null;
				try {
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename.txt"), "utf-8"));
					writer.write(entrada);
					writer.close();
				} catch (IOException IOEerro) {
					System.out.print("Erro: " + IOEerro.toString());
				}

				File arq;
				arq = new File("C:\\Users\\kms4\\Documents\\infrasoft\\src");
				byte[] dados = new byte[1024 * 1024];
				int tamanho = System.in.read(dados);
				while (tamanho > 0) {
					stub.writefile(arq.getName(), dados, tamanho);
					tamanho = System.in.read(dados);
				}
				}else if(command.equals("open")) { //se for open, vamos abrir o arquivo, no método open file na interface
					String nome=in.next();
					stub.openfile(nome);
					

			}
			}catch (Exception e) {
				System.err.println("Erro" + e.toString());

			}
		}

	}

