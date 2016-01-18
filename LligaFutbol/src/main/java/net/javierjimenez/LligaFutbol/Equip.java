package net.javierjimenez.LligaFutbol;

public class Equip {

	private String nomEquip;
	private int punts;
	private int gols;
	
	public Equip(String n) {
		
		nomEquip = n;
		punts = 0;
		gols = 0;
		
	}
	
	public String getNom() {
		
		return nomEquip;
		
	}
	
	public int getPunts() {
		
		return punts;
		
	}
	
	public void setPunts(int p) {
		
		punts = punts + p;
		
	}
	
}
