import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread
{
	private final ObjectOutputStream oos;
	private final ObjectInputStream ois;
	private final Socket socket;
	
	public ClientHandler(Socket socket, ObjectOutputStream oos, ObjectInputStream ois)
	{
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
