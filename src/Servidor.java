import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor 
{
	private static ServerSocket server;
	private static int port = 2600;

	public static void main(String[] args)
	{
		try
		{
			server = new ServerSocket(port);
			while (true)
			{
				System.out.println("Esperando la entrada del cliente");
				Socket socket = server.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				Thread nuevoHilo = new ClientHandler(socket, oos, ois);
				nuevoHilo.start();
				System.out.println("Nuevo cliente creado!!");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
