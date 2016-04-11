package logikoa;

public class Jokoa {


	private int zutabeak;
	private int lerroak;
	private  String [][] arraya;
	private int bonbaKop;

	public Jokoa(int zailtasuna) {
		if (zailtasuna==1){
			this.zutabeak=8;
			this.lerroak=8;
			this.bonbaKop=10;
		}
		else if (zailtasuna==2){
			this.zutabeak=16;
			this.lerroak=16;
			this.bonbaKop=40;
		}
		else if (zailtasuna==3){
			this.zutabeak=30;
			this.lerroak=16;
			this.bonbaKop=99;
		}
		this.arraya=new String [zutabeak][lerroak];
	}

	public int getzutabeak (){
		return zutabeak;
	}

	public int getlerroak (){
		return lerroak;
	}
	
	public int getBonbak(){
		return bonbaKop;
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
					if (z-1 >= 0 && i >= 0 && z-1 < lerroak-1 && i < zutabeak-1&&arraya[i][z-1] == "B"){
						laukizenbakia++;
					}
					if (z-1 >= 0 && i-1 >= 0 && z-1 < lerroak-1 && i-1 < zutabeak-1&&arraya[i-1][z-1] == "B"){
						laukizenbakia++;
					}
					if (z-1 >= 0 && i+1 >= 0 && z-1 < lerroak-1 && i+1 < zutabeak-1&&arraya[i+1][z-1] == "B"){
						laukizenbakia++;
					}
					if (z+1 >= 0 && i >= 0 && z+1 < lerroak-1 && i < zutabeak-1&&arraya[i][z+1] == "B"){
						laukizenbakia++;
					}
					if (z+1 >= 0 && i+1 >= 0 && z+1 < lerroak-1 && i+1 < zutabeak-1&&arraya[i+1][z+1] == "B"){
						laukizenbakia++;
					}
					if (z+1 >= 0 && i-1 >= 0 && z+1 < lerroak-1 && i-1 < zutabeak-1&&arraya[i-1][z+1] == "B"){
						laukizenbakia++;
					}
					if (z >= 0 && i+1 >= 0 && z < lerroak-1 && i+1 < zutabeak-1&&arraya[i+1][z] == "B"){
						laukizenbakia++;
					}
					if (z >= 0 && i-1 >= 0 && z < lerroak-1 && i-1 < zutabeak-1&&arraya[i-1][z] == "B"){
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

	public String getText(int z, int l) {
		return arraya[z][l];
	}
}
