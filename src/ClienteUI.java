import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteUI {

	private JFrame frame;
	private JTextField emailToText;
	private JTextField asuntoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteUI window = new ClienteUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClienteUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailToText = new JTextField();
		emailToText.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		emailToText.setBounds(150, 90, 600, 50);
		frame.getContentPane().add(emailToText);
		emailToText.setColumns(10);
		
		asuntoText = new JTextField();
		asuntoText.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		asuntoText.setBounds(150, 160, 600, 50);
		frame.getContentPane().add(asuntoText);
		asuntoText.setColumns(10);
		
		JTextArea contenidoText = new JTextArea();
		contenidoText.setBounds(150, 250, 582, 189);
		frame.getContentPane().add(contenidoText);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnNewButton.setBackground(new Color(187, 210, 232));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(350, 500, 153, 52);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Para");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(50, 97, 90, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAsunto.setBounds(50, 164, 90, 29);
		frame.getContentPane().add(lblAsunto);
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContenido.setBounds(10, 242, 130, 29);
		frame.getContentPane().add(lblContenido);
	}
}