import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8080);

			//Luana vai botar Mateus Na Lei

			System.out.println("Esperando conexao...");
			Socket conexaoCliente = server.accept();
			System.out.println("CHEGOU CONEXAO !");


			InputStream is = conexaoCliente.getInputStream();
			OutputStream os = conexaoCliente.getOutputStream();

			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis =  new DataInputStream(is);

			String resp = "HTTP/1.1 200 OK\r\nContent-Type:text/html\n\n" +
					"<html><title> Aula ISI - </title><h3> Aula Socket</h3></html>";

			dos.write(resp.getBytes());


			Thread.sleep(2000);
			int x = 0;
			while((x = is.read())!=-1) {
				System.out.print((char)x);

				dos.write("foda se".getBytes());


				//os.write("power".getBytes());
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
