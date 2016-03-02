package grafikoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Login {

	private JFrame frame;
	private JTextField user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		user = new JTextField();
		user.setBounds(28, 37, 209, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(28, 81, 209, 20);
		comboBox.addItem("Erraza");
		comboBox.addItem("Ertaina");
		comboBox.addItem("Zaila");
		frame.getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(28, 112, 428, 215);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Sartu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(user.getText() + " erabiltzailea jokatzen ari da");
				if (comboBox.getSelectedItem().toString()=="Erraza"){
					textArea.setText("Kaixo " + user.getText() + " aukera erraza hartu duzu.");
					logikoa.Erraza e = new logikoa.Erraza();
					e.start_actionPerformed(arg0);	
				}
				else if (comboBox.getSelectedItem().toString()=="Ertaina"){
					textArea.setText("Kaixo " + user.getText() + " aukera ertaina hartu duzu.");
					logikoa.Ertaina e = new logikoa.Ertaina();
					e.start_actionPerformed(arg0);	
				}
				else if (comboBox.getSelectedItem().toString()=="Zaila"){
					textArea.setText("Kaixo " + user.getText() + " aukera zaila hartu duzu.");
					logikoa.Zaila z = new logikoa.Zaila();
					z.start_actionPerformed(arg0);	
				}
			}
		});
		btnNewButton.setBounds(278, 36, 177, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ranking-a lortu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(278, 80, 177, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
