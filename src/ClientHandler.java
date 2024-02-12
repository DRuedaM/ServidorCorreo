import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import javax.imageio.spi.ImageOutputStreamSpi;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ClientHandler extends Thread
{
	private final ObjectOutputStream oos;
	private final ObjectInputStream ois;
	private final Socket socket;
	
	private String emailFrom = "davidruedamartin26@gmail.com";
	private String passwordFrom = "wgwy gfgl ghhb bpzg";
	private String emailTo;
	private String subject;
	private String content;
	
	private Properties mProperties;
	private Session mSession;
	private MimeMessage mCorreo;
	
	
	public ClientHandler(Socket socket, ObjectOutputStream oos, ObjectInputStream ois)
	{
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		mProperties = new Properties();
	}
	
	@Override
	public void run() 
	{
			try 
			{
				String message = (String) ois.readObject();
				System.out.println("Mensaje recibido: " + message);
				String[] envio = message.split(",");
				createEmail(envio);
				sendEmail();
				oos.writeObject("El correo ha sido enviado correctamente");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
	
	private void createEmail(String[] datos)
	{
		emailTo = datos[0];
		subject = datos[1];
		content = datos[2];
		
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", emailFrom);
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");
		
		mSession = Session.getDefaultInstance(mProperties);
		mCorreo = new MimeMessage(mSession);
		try 
		{
			mCorreo.setFrom(new InternetAddress(emailFrom));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "ISO-8859-1", "html");
		} 
		catch (AddressException e) 
		{
			e.printStackTrace();
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void sendEmail()
	{
		try 
		{
			Transport mTransport = mSession.getTransport("smtp");
			mTransport.connect(emailFrom, passwordFrom);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();
		} 
		catch (NoSuchProviderException e) 
		{
			e.printStackTrace();
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
	
}
