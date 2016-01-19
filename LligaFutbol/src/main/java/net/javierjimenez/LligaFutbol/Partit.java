package net.javierjimenez.LligaFutbol;

public class Partit {

	private String [] equips = new String[2];
	private int [] gols = new int [2];
	private int quantsEquips = 0;
	
	public Partit (){
			
	}
	
	public void addEquip(String nom, int gol){
		
		equips[quantsEquips] = nom;
		gols[quantsEquips] = gol;
		quantsEquips++;
		
	}
	
	public boolean HiHaDosEquips() {
		
		if (quantsEquips == 2){
			return true;
		} else {
			return false;
		}
		
	}
	
	public String guanyador() {
		
		quantsEquips = 0;
		
		if(gols[0] > gols[1]){
			
			String nom = equips[0];
			
			equips = new String[2];
			gols = new int [2];
			
			return nom;
			
		} else if (gols[0] < gols[1]){
			
			String nom = equips[1];
			
			equips = new String[2];
			gols = new int [2];
			
			return nom;
			
		} else {
			String noms = equips[0] + "-" + equips[1];
			
			equips = new String[2];
			gols = new int [2];
			
			return noms;
			
		}
	}
}
