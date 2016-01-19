package net.javierjimenez.LligaFutbol;

public class Equip implements Comparable<Equip>{

	@Override
	public String toString() {
		return "Equip [nomEquip=" + nomEquip + ", punts=" + punts + "]";
	}

	private String nomEquip;
	private int punts;
	
	public Equip(String n) {
		
		nomEquip = n;
		punts = 0;
		
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

	@Override
	public int compareTo(Equip o) {
		
		if (punts > o.getPunts()) {
			
			return 1;
			
		} else if (punts < o.getPunts()) {
			
			return -1;
		} 
		   
		return 0;
	}
}
