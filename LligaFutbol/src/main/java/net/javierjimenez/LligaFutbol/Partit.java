package net.javierjimenez.LligaFutbol;

/**
 * 
 * @author alumne1daw
 *
 */
public class Partit {

	/**
	 * Array de String que conte els noms
	 * dels equips que jugen el partit
	 */
	private String [] equips = new String[2];
	
	/**
	 * Array de int que conte els gols
	 * dels equips que juguen el partit
	 */
	private int [] gols = new int [2];
	
	/**
	 * Variable int que utilitzem per poder insertar els
	 * noms i els gols dels 2 equips que juguen en la 
	 * seva respectiva array.
	 */
	private int quantsEquips = 0;
	
	/**
	 * Constructor principal de l'objecte Partit
	 */
	public Partit (){
			
	}
	
	/**
	 * Metode que serveix per guardar el nom i el total
	 * de gols d'un equip.
	 * 
	 * @param nom
	 * @param gol
	 */
	public void addEquip(String nom, int gol){
		
		equips[quantsEquips] = nom;
		gols[quantsEquips] = gol;
		quantsEquips++;
		
	}
	
	/**
	 * Metode per saber si tenim ja 2 equips jugant
	 * 
	 * @return Variable boolean
	 */
	public boolean HiHaDosEquips() {
		
		if (quantsEquips == 2){
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Metode per saber quin dels dos equips es el guanyador.
	 * 
	 * @return Variable String
	 */
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
