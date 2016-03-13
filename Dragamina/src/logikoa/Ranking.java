package logikoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Ranking {

	TreeMap<Integer, String> ranking;
	static Ranking nRanking;
	
	private Ranking(){
		ranking = new TreeMap<Integer, String>();	
	}
	
	public static synchronized Ranking getRanking(){
		if (nRanking == null){
			nRanking = new Ranking();
		}
		return nRanking;
	}
	
	public void rankingasortu(){
		ranking.put(10, "Aitor");
		ranking.put(2, "Pedro");
		ranking.put(40, "Jon");
		ranking.put(31, "Idoia");
		ranking.put(53, "Juan");
		ranking.put(62, "Iñigo");
		ranking.put(1, "Iñigo");
	}
	
	public int getSize(){
		return Ranking.getRanking().ranking.size();
	}
	
	public void rankingaEzabatu(){
		ranking = new TreeMap<Integer, String>();
	}
	

}
