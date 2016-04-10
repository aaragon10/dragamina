package logikoa;

public class Jokoa {

	
	private int zutabeak;
	private int lerroak;
	private  String [][] arraya;
	private int bonbaKop;
	
	public Jokoa(int zailtasuna) {
		if (zailtasuna==1){
			this.zutabeak=10;
			this.lerroak=10;
		}
		else if (zailtasuna==2){
			this.zutabeak=19;
			this.lerroak=12;
		}
		else if (zailtasuna==3){
			this.zutabeak=40;
			this.lerroak=20; 
		}
		this.bonbaKop=getzutabeak();
		this.arraya=new String [zutabeak][lerroak];
	}
	
	public int getzutabeak (){
		return zutabeak;
	}
  
	public int getlerroak (){
		return lerroak;
	}
	
	
	public void bonbaJarri(){
		double i=0;
		double z=0;
		int kopurua = 0;
		do  {
			i=Math.random()*getzutabeak();
			z=Math.random()*getlerroak();
			i=(int)i;
			z=(int)z;
			if  (z!=0 && i!=0 && z!=lerroak-1 && i!=zutabeak-1){
				arraya[(int)i][(int) z ]="B";
				kopurua++;
			}
		}
		while (bonbaKop != kopurua);
	}
	

	public void zenbakiakJarri() {
		for (int i=0; i < zutabeak; i++){
			for (int z=0; z < lerroak ; z++){
				int laukizenbakia = 0;
				if (arraya[i][z] != ("B")){
					if  (z != 0 && i != 0 && z != lerroak-1 && i != zutabeak-1){
//						System.out.println(i+ " " + z + " "+ zutabeak + " " + lerroak);
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
						}else{
							arraya[i][z]=" ";
						}
					}
				}
			}
		}
	}

	public String getText(int z, int l) {
		return arraya[z][l];
	}
}