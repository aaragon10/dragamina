package logikoa;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
 
public class Erraza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panela = new JPanel();
	private JButton start = new JButton();
	private int zutabeak=10;
	private int lerroak=10;
	public  JButton taula[][]=new JButton [zutabeak][lerroak];
	public  String [][] arraya =new String [zutabeak][lerroak];
 
	//Zutabeak kontutan hartuta, bonbak esleitzen dira 
 
	public static void main (String [] args){
		Erraza dragaminaTaula = new Erraza();
	}
	
	public Erraza()  {
		try    {
			hasieratu();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
 
	public void hasieratu() throws Exception  {
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
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				start_actionPerformed(e);
			}
		});
		this.getContentPane().add(start, null);
		this.getContentPane().add(panela, null);
		taulaKargatu();
		bonbaJarri(getzutabeak()-5);
		konprobatu();
		this.setVisible(true);  
 
		taulaEzkutatu();
	}
	public void start_actionPerformed(ActionEvent e)  {
		for (int i=0;i<zutabeak;i++){
			for (int z=0;z<lerroak;z++){
				arraya[i][z]=" ";
				taula[i][z].setEnabled(true);
				taula[i][z].setText(" ");
			}
		}
		bonbaJarri(getzutabeak()-5);
		konprobatu();
		this.setTitle("Dragamina");
		start.setText("HASI");
	}
 
	public void taulaKargatu(){
		for (int i=0;i<zutabeak;i++){
			for (int z=0;z<lerroak;z++){
				arraya[i][z]=" ";
				taula[i][z]= new JButton();
				panela.add(taula[i][z]);
				taula[i][z].setBounds(i*25,z*25,25,25);
				taula[i][z].setMargin(new Insets(0, 0, 0, 0));
				taula[i][z].setFont(new Font("Tahoma", 0,10));
 
				taula[i][z].addActionListener(
						new ActionListener(){
							public void actionPerformed(ActionEvent ar) {
								for (int i=0;i<zutabeak;i++){
									for (int z=0;z<lerroak;z++){
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
 
	public void bonbaJarri(int bonbaKop){
		double i=0;
		double z=0;
		int condicion=0;
		do  {
			i=Math.random()*getzutabeak();
			z=Math.random()*getlerroak();
			i=(int)i;
			z=(int)z;
			if  (z!=0 && i!=0 && z!=lerroak-1 && i!=zutabeak-1){
				arraya[(int)i][(int) z ]="B";
				condicion++;
			}
		}
		while (condicion<=zutabeak);
	}
  
	public void setzutabeak (int szutabeak){
		zutabeak=szutabeak;
	}
	
	public int getzutabeak (){
		return zutabeak;
	}
  
	public void setlerroak (int slerroak){
		lerroak=slerroak;
	}
  
	public int getlerroak (){
		return lerroak;
	}
 
	//�- Asigna un n�mero a cada boton dependiendo de las B que tenga al lado.
	public void konprobatu(){
		for (int i=0; i < zutabeak; i++){
			for (int z=0; z < lerroak ; z++){
				int laukizenbakia = 0;
				if (arraya[i][z] != ("B")){
					if  (z != 0 && i != 0 && z != lerroak-1 && i != zutabeak-1){
						System.out.println(i+ " " + z + " "+ zutabeak + " " + lerroak);
						if (arraya[i][z-1] == "B"){
							laukizenbakia++;
						}
						if (arraya[i-1][z-1] == "B"){
							laukizenbakia++;
						}
						if (arraya[i+1][z-1] == "B"){
							laukizenbakia++;
						}
						if (arraya[i][z+1] == "B"){
							laukizenbakia++;
						}
						if (arraya[i+1][z+1] == "B"){
							laukizenbakia++;
						}
						if (arraya[i-1][z+1] == "B"){
							laukizenbakia++;
						}
						if (arraya[i+1][z] == "B"){
							laukizenbakia++;
						}
						if (arraya[i-1][z] == "B"){
							laukizenbakia++;
						}	
						if (laukizenbakia != 0){
							arraya[i][z]=(String.valueOf(laukizenbakia));
						}    
					}
				}
			}
		}
	}
	
	public void taulaEzkutatu(){
		for (int i = 0; i < zutabeak; i++){
			for (int z = 0; z < lerroak; z++){
				if  (z==0 || i==0 || z==lerroak-1 || i==zutabeak-1){
					taula[i][z].setVisible(false);
				}       
			}
		}   
	}
 

	public void textotaula(){
		for (int i=0;i<zutabeak;i++){
			for (int z=0;z<lerroak;z++){
				taula[i][z].setText(arraya[i][z]);
				taula[i][z].setEnabled(false);
			}   
		}   
	}
	
 
	public void showTextTop(int i,int z){
		taula[i][z].setText(arraya[i][z]);
		taula[i][z].setEnabled(false);
		
		if (arraya[i][z]==" "){
			taula[i][z].setEnabled(false);
			StackOverflowMetodoa(i,z);
		}
		else {
			taula[i][z].setEnabled(false);
		}
		if (taula[i][z].getText()=="B"){
			textotaula();
		}
		
	}
	
	//Zenbakiak jartzeko
 
	private void StackOverflowMetodoa(int i, int z) {
		if ( z!=0 && i!=0 && z!=lerroak-1 && i!=zutabeak-1){
			taula[i-1][z].setEnabled(false);
			taula[i-1][z-1].setEnabled(false);
			taula[i-1][z+1].setEnabled(false);
			taula[i][z-1].setEnabled(false);
			taula[i][z+1].setEnabled(false);
			taula[i+1][z].setEnabled(false);
			taula[i+1][z+1].setEnabled(false);
			taula[i+1][z-1].setEnabled(false);
			taula[i-1][z].setText(arraya[i-1][z]);
			taula[i-1][z-1].setText(arraya[i-1][z-1]);
			taula[i-1][z+1].setText(arraya[i-1][z+1]);
			taula[i][z-1].setText(arraya[i][z-1]);
			taula[i][z+1].setText(arraya[i][z+1]);
			taula[i+1][z].setText(arraya[i+1][z]);
			taula[i+1][z+1].setText(arraya[i+1][z+1]);
			taula[i+1][z-1].setText(arraya[i+1][z-1]);
			
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


	public void finalGame (){
		int contadorFinal=0;
		for (int i=1;i<zutabeak-1;i++){
			for (int z=1;z<lerroak-1;z++){
				if (taula[i][z].getText()==" " || taula[i][z].getText()=="1" ||
						taula[i][z].getText()=="2" || taula[i][z].getText()=="3" ||
						taula[i][z].getText()=="5" || taula[i][z].getText()=="4" ){
					contadorFinal++;
					if (contadorFinal==171){
						this.setTitle("ZORIONAK! Partida irabazi duzu!");
						start.setText("BERRIA");
					}
				}
			}
		}
	}
 
}
