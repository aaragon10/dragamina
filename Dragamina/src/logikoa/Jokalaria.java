package logikoa;

public class Jokalaria {
	String izena;
	int puntuak;
	
	public Jokalaria(int ppuntuak, String pizena){
		izena = pizena;
		puntuak = ppuntuak;
	}
	
	public void setIzena(String pizena){
		izena = pizena;
	}

	public String getIzena() {
		return izena;
	}

	public int getPuntuak() {
		return puntuak;
	}
	
	
}
