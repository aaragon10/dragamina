package controller;

import logikoa.Jokoa;

public class TableroController {

	private static TableroController instantzia=new TableroController();
	private Jokoa jokoa;

	private TableroController(){
	}

	public static TableroController getTableroController(){
		return instantzia;
	}

	public void tableroaHasieratu(int zail){
		jokoa= new Jokoa(zail);
		jokoa.bonbaJarri();
		jokoa.zenbakiakJarri();
	}

	public int getZutabeak(){
		return jokoa.getzutabeak();
	}

	public int getLerroak(){
		return jokoa.getlerroak();
	}

	public String getText(int z, int l) {
		return jokoa.getText(z, l);
	}
	
	public int getBonbak(){
		return jokoa.getBonbak();
	}

}
