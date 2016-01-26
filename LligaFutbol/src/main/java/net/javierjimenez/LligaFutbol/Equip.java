package net.javierjimenez.LligaFutbol;

/**
 * 
 * @author alumne1daw
 *
 */
public class Equip implements Comparable<Equip>{

	/**
	 * Variable String que conté el nom de l'objecte Equip
	 */
	private String nomEquip;
	
	/**
	 * Variable int que conté els punts de l'onjecte Equip
	 */
	private int punts;
	
	/**
	 * Constructor principal de l'objecte Equip
	 * 
	 * @param n Variable String que conte el nom de l'objecte
	 */
	public Equip(String n) {
		
		nomEquip = n;
		punts = 0;
		
	}
	
	/**
	 * Metode que retorna el nom de l'objecte
	 * 
	 * @return Variable String
	 */
	public String getNom() {
		return nomEquip;
	}
	
	/**
	 * Metode que retorna els punts de l'objecte
	 * 
	 * @return Variable int
	 */
	public int getPunts() {
		return punts;
	}
	
	/**
	 * Metode que suma punts a l'objecte equip
	 * 
	 * @param p Variable int que conte els nous punts a sumar.
	 */
	public void setPunts(int p) {
		punts = punts + p;
	}

	
	/**
	 * Metode encarregat d'ordenar de major a menor els
	 * equips per els punts
	 */
	@Override
	public int compareTo(Equip o) {
		
		if (punts > o.getPunts()) {
			
			return -1;
			
		} else if (punts < o.getPunts()) {
			
			return 1;
		} 
		   
		return 0;
	}
}
