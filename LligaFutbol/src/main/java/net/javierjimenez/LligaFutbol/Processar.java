package net.javierjimenez.LligaFutbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author alumne1daw
 *
 */
public class Processar extends DefaultHandler {
	
	/**
	 * Variables boolean utilitzades per delimitar el xml
	 */
	boolean llistantEquips, nomEquip, jornada, partit, resultat = false;
	
	/**
	 * Variable String que utilitzarem per guardar el nom de l'equip
	 */
	private String nom = null;
	
	/**
	 * Variable int que utilitzarem per guardar el
	 * total de gols d'un equip
	 */
	private int gols = 0;
	
	/**
	 * Objecte de tipus Partit que farem per
	 * saber quin equip guanya cada partit
	 */
	private Partit P = new Partit();
	
	/**
	 * HashMap que conte el total d'equips que juguen cada jornada.
	 */
	private HashMap<String, Equip> equips = new HashMap<String, Equip>();
	
	/**
	 * Llista que conte el total d'equips que hi han cada jornada
	 */
	private  List<Equip> lliga;
	
	/**
	 * Metode de final de lectura del document xml on imprimirem
	 * per consola el total de punts de cada equip i quin es el 
	 * guanyador de cada jornada.
	 */
	public void endDocument() throws SAXException {

		lliga = new ArrayList<Equip>(equips.values());
		
		System.out.println("Resultat");
		System.out.println();
		
		for (int i = 0; i < lliga.size(); i++){
			
			System.out.println("Equip " + lliga.get(i).getNom() + ": " + lliga.get(i).getPunts() + " punts");
			
		}
		
		Collections.sort(lliga);
		
		System.out.println();
		System.out.println("Guanyador Equip " + lliga.get(0).getNom() + "!!");
		System.out.println();
		
		equips.clear();
	}

	/**
	 * Metode de lectura on, segons quina etiqueta s'inicii, capturarem una secció del
	 * XML o una altre.
	 */
	public void startElement(String uri, String localName, String qName, Attributes attr) {
		
		switch(qName) {
		
		case "llista-equips":
			llistantEquips = true;
			break;
		case "nom":
			if (llistantEquips || partit) {
				nomEquip = true;
			} 
			break;
		case "resultat":
			if (partit) {
				resultat = true;
			}
			break;
		case "jornada":
			System.out.println("Jornada " + attr.getValue("num"));
			System.out.println();
			jornada = true;
		case "partit":
			partit = true;
			break;
		}
	}
	
	/**
	 * Metode de lectura dels valors de cada etiqueta on, segons les
	 * etiquetes que estiguem llegint, creará un nou equip o bé
	 * emmagatzemara el nom i gols de cada equip per cada partit.
	 */
	public void characters(char [] ch, int start, int length) {
		
		if(llistantEquips && nomEquip){
			equips.put(new String (ch, start, length), new Equip(new String (ch, start, length)));
			nomEquip = false;
		}
		
		if(partit && nomEquip){
			nom = new String (ch, start, length);
		}
		
		if (partit && resultat){
			gols = Integer.parseInt(new String (ch, start, length));
			System.out.println("Equip " + nom + " - " + gols + " Gol(s)");
		}
	}
	
	/**
	 * Metode de lectura de documents XML on, al tancar cada etiqueta, 
	 * posara a false els booleans encarregats de capturar un conjunt
	 * d'etiquetes o be fara que dos equips juguin un partit.
	 */
	public void endElement(String uri, String localName, String qName) {
		switch(qName) {
		case "llista-equips":
			llistantEquips = false;
			break;	
		case "nom":
			nomEquip = false;
			break;
		case "partit":
			System.out.println();
			partit = false;
			break;
		case "jornada":
			jornada = false;
			break;
		case "resultat":
			
			boolean resolucio = P.HiHaDosEquips();
			
			if (resolucio){
				
				String resultat = P.guanyador();
				
				if (equips.containsKey(resultat)){
					
					equips.get(resultat).setPunts(3);
					
				} else {
					
					String [] noms = resultat.split("-");
					
					equips.get(noms[0]).setPunts(1);
					equips.get(noms[1]).setPunts(1);
				}
				
			} else {
				
				P.addEquip(nom, gols);
			}
			
			resultat = false;
			break;
		}
	}
}