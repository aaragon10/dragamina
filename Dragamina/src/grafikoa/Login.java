package grafikoa;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Login {

	private JFrame frame;
	private JTextField user;
	private Integer puntuak;
	private String izena;

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

	JTextArea textArea = new JTextArea();

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
				//Jokalaria j = new Jokalaria(0, textArea.getText());
				if (comboBox.getSelectedItem().toString()=="Erraza"){
					textArea.setText("Kaixo " + user.getText() + " aukera erraza hartu duzu.");
					Tableroa tableroa = new Tableroa(1);
					tableroa.start_actionPerformed();	
				}
				else if (comboBox.getSelectedItem().toString()=="Ertaina"){
					textArea.setText("Kaixo " + user.getText() + " aukera ertaina hartu duzu.");
					Tableroa tableroa = new Tableroa(2);
					tableroa.start_actionPerformed();	
				}
				else if (comboBox.getSelectedItem().toString()=="Zaila"){
					textArea.setText("Kaixo " + user.getText() + " aukera zaila hartu duzu.");
					Tableroa tableroa = new Tableroa(3);
					tableroa.start_actionPerformed();	
				}
			}
		});
		btnNewButton.setBounds(278, 36, 110, 65);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Ranking-a lortu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("Gure partida guztien ranking-a hau da.\n\n");
				logikoa.Ranking.getRanking().rankingasortu();				

				ArrayList<Integer> keys = new ArrayList<Integer>(logikoa.Ranking.getRanking().ranking.keySet());

				for(int i=keys.size(); i==0;i--){
					System.out.println(logikoa.Ranking.getRanking().ranking.get(keys.get(i)));
				}

			}
		});
		btnNewButton_1.setBounds(407, 36, 123, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnRankingaEzabatu = new JButton("Ranking-a ezabatu");
		btnRankingaEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logikoa.Ranking.getRanking().rankingaEzabatu();
				textArea.setText("Ranking-a ezabatu da");
			}
		});
		btnRankingaEzabatu.setBounds(407, 80, 123, 23);
		frame.getContentPane().add(btnRankingaEzabatu);

	}

	public String jokalariIzena(){
		return textArea.getText();
	}
}
