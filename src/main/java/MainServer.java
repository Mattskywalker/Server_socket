import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8080);


			System.out.println("Esperando conexao...");
			Socket conexaoCliente = server.accept();
			System.out.println("CHEGOU CONEXAO !");


			InputStream is = conexaoCliente.getInputStream();
			OutputStream os = conexaoCliente.getOutputStream();

			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis =  new DataInputStream(is);

			String resp = "HTTP/1.1 200 OK\r\nContent-Type:text/html\n\n" +
					"<!DOCTYPE html>\n" +
					"<html lang=\"en\">\n" +
					"<head>\n" +
					"    <meta charset=\"UTF-8\">\n" +
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
					"    <title>Document</title>\n" +
					"</head>\n" +
					"<body style=\"background-color: grey;\">\n" +
					"    <script>\n" +
					"        let d = new Date();\n" +
					"    \n" +
					"        function tentar(){\n" +
					"            if(document.getElementById('time').value ==  \"00\" +\":\"+ d.getSeconds()){\n" +
					"            document.body.innerHTML = \"<h1>Você acertou, \"+document.getElementById('nome').value+ \" :)\"+\"</h1><br><h1>você chutou:\"+document.getElementById('time').value+\"</h1><br><h1>Time right now is:  \" + d.getHours() + \":\" + d.getMinutes() + \":\" + d.getSeconds()\n" +
					"        \"</h1>\"\n" +
					"           \n" +
					"            \n" +
					"        }\n" +
					"        else{\n" +
					"            document.body.innerHTML = \"<h1>Você Errou, \"+document.getElementById('nome').value+ \" :(\"+ \"</h1><br><h1>você chutou:\"+document.getElementById('time').value+\"</h1><br><h1>Time right now is:  \" + d.getHours() + \":\" + d.getMinutes() + \":\" + d.getSeconds()\n" +
					"        \"</h1>\" \n" +
					"        }\n" +
					"        }\n" +
					"        \n" +
					"        </script> \n" +
					"        <div style=\"display: flex; flex-direction: column; align-items: center; margin-top: 20%; margin-left: 40%; background-color: darkgreen; width: 300px; height: 170px;border-radius: 12px;\">\n" +
					"            <label for=\"nome\" style=\"font-size: large;\">Insira seu nome:  </label> \n" +
					"            <input type=\"text\" id=\"nome\" style=\"margin-top: 3%;\"> \n" +
					"            <br>\n" +
					"            <label for=\"time\" >Insira quantos segundos você acha que está:  </label> \n" +
					"            <input type=\"time\" id=\"time\" style=\"margin-top: 3%;\" min=\"00:00\" max=\"00:59\" required>\n" +
					"                <button type=\"submit\" onclick=\"tentar()\" style=\"margin-top: 3%;\">enviar</button></div>\n" +
					"</body>\n" +
					"</html>";

			dos.write(resp.getBytes());


			Thread.sleep(2000);
			int x = 0;
			while((x = is.read())!=-1) {
				System.out.print((char)x);

				dos.write(" ".getBytes());


				//os.write("power".getBytes());
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
