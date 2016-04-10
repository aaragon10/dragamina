package grafikoa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.TableroController;

public class Tableroa extends JFrame {

	private JPanel panela = new JPanel();
	private JButton start = new JButton();
	public  JButton taula[][];
	
	public Tableroa(int zailtasuna){
		try    {
			System.out.println("tablaroa hasieratu");
			this.getContentPane().setLayout(null);
			this.setSize(new Dimension(291, 318));
			this.setTitle("Dragamina");
			panela.setBounds(new Rectangle(0, 40, 268, 239));
			panela.setBackground(new Color(0, 200, 200));
			panela.setLayout(null);
			start.setText("Hasi");
			start.setBounds(new Rectangle(0, 0, 125, 40));
			start.setFont(new Font("Calibri", 0, 12));
			start.setHorizontalTextPosition(SwingConstants.CENTER);
			start.setAlignmentY((float)0.0);
			start.setMargin(new Insets(2, 14, 2, 12));
			System.out.println("1");
			start.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					start_actionPerformed();
				}
			});
			this.getContentPane().add(start, null);
			this.getContentPane().add(panela, null);
			TableroController.getTableroController().tableroaHasieratu(zailtasuna);
			taula= new JButton[TableroController.getTableroController().getZutabeak()][TableroController.getTableroController().getLerroak()];
			taulaKargatu();
			this.setVisible(true);
			System.out.println("2");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void start_actionPerformed()  {
		for (int i=0;i<taula.length;i++){
			for (int z=0;z<taula[0].length;z++){
				taula[i][z].setEnabled(true);
				taula[i][z].setText(" ");
			}
		}
		this.setTitle("Dragamina");
		start.setText("HASI");
	}
	
	public void taulaKargatu(){
		for (int i=0;i<taula.length;i++){
			for (int z=0;z<taula[0].length;z++){
				taula[i][z]= new JButton();
				panela.add(taula[i][z]);
				taula[i][z].setBounds(i*25,z*25,25,25);
				taula[i][z].setMargin(new Insets(0, 0, 0, 0));
				taula[i][z].setFont(new Font("Tahoma", 0,10));
 
				taula[i][z].addActionListener(
						new ActionListener(){
							public void actionPerformed(ActionEvent ar) {
								for (int i=0;i<taula.length;i++){
									for (int z=0;z<taula[0].length;z++){
										if (ar.getSource()==taula[i][z]){
											showTextTop(i,z);
										} 
									}        
								}
							}
						}
				);             
 
			}
		}
	}
	

	public void showTextTop(int i,int z){
		String text=TableroController.getTableroController().getText(i, z);
		System.out.println("-"+text+"-");
		taula[i][z].setText(text);
		taula[i][z].setEnabled(false);
		
		if (text==" "){
			taula[i][z].setEnabled(false);
			zuriuneakZabaldu(i,z);
		}
		else {
			taula[i][z].setEnabled(false);
		}
		if (taula[i][z].getText()=="B"){
			textotaula();
		}
		
	}
	
	private void zuriuneakZabaldu(int i, int z) {
		if ( z!=0 && i!=0 && z!=taula[0].length-1 && i!=taula.length-1){
			taula[i-1][z].setEnabled(false);
			taula[i-1][z-1].setEnabled(false);
			taula[i-1][z+1].setEnabled(false);
			taula[i][z-1].setEnabled(false);
			taula[i][z+1].setEnabled(false);
			taula[i+1][z].setEnabled(false);
			taula[i+1][z+1].setEnabled(false);
			taula[i+1][z-1].setEnabled(false);
			taula[i-1][z].setText(TableroController.getTableroController().getText(i-1, z));
			if(TableroController.getTableroController().getText(i-1, z)==" "){
				zuriuneakZabaldu(i-1, z);
			}
			taula[i-1][z-1].setText(TableroController.getTableroController().getText(i-1, z-1));
			if(TableroController.getTableroController().getText(i-1, z-1)==" "){
				zuriuneakZabaldu(i-1, z-1);
			}
			taula[i-1][z+1].setText(TableroController.getTableroController().getText(i-1, z+1));
			if(TableroController.getTableroController().getText(i-1, z+1)==" "){
				zuriuneakZabaldu(i-1, z+1);
			}
			taula[i][z-1].setText(TableroController.getTableroController().getText(i, z-1));
			if(TableroController.getTableroController().getText(i, z-1)==" "){
				zuriuneakZabaldu(i, z-1);
			}
			taula[i][z+1].setText(TableroController.getTableroController().getText(i, z+1));
			if(TableroController.getTableroController().getText(i, z+1)==" "){
				zuriuneakZabaldu(i, z+1);
			}
			taula[i+1][z].setText(TableroController.getTableroController().getText(i+1, z));
			if(TableroController.getTableroController().getText(i+1, z)==" "){
				zuriuneakZabaldu(i+1, z);
			}
			taula[i+1][z+1].setText(TableroController.getTableroController().getText(i+1, z+1));
			if(TableroController.getTableroController().getText(i+1, z+1)==" "){
				zuriuneakZabaldu(i+1, z+1);
			}
			taula[i+1][z-1].setText(TableroController.getTableroController().getText(i+1, z-1));
			if(TableroController.getTableroController().getText(i+1, z-1)==" "){
				zuriuneakZabaldu(i+1, z-1);
			}
			
//			StackOverflowMetodoa(i-1, z);
//			StackOverflowMetodoa(i-1, z-1);
//			StackOverflowMetodoa(i-1, z+1);
//			StackOverflowMetodoa(i, z-1);
//			StackOverflowMetodoa(i, z+1);
//			StackOverflowMetodoa(i+1, z);
//			StackOverflowMetodoa(i+1, z+1);
//			StackOverflowMetodoa(i+1, z-1);
//			taula[i][z].setText(" ");
		}
	}
	
	public void textotaula(){
		for (int i=0;i<taula.length;i++){
			for (int z=0;z<taula[0].length;z++){
				taula[i][z].setText(TableroController.getTableroController().getText(i, z));
				taula[i][z].setEnabled(false);
			}   
		}   
	}
	
}
