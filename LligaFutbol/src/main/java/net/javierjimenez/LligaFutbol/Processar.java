package net.javierjimenez.LligaFutbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {
	
	boolean llistantEquips, nomEquip, jornada, partit, resultat = false;
	
	String nom = null;
	
	int gols = 0;
	
	Partit P = new Partit();
	
	HashMap<String, Equip> equips = new HashMap<String, Equip>();
	
	private  List<Equip> lliga = new ArrayList<Equip>();
	
	public void endDocument() throws SAXException {

		for (Equip e : equips.values()){
			
			System.out.println("Equip " + e.getNom() + ": " + e.getPunts() + " punts");
			
			lliga.add(e);
			
		}
		
		Collections.sort(lliga);
		
		System.out.println();
		System.out.println("Guanyador Equip " + lliga.get(0).getNom() + "!!");
		System.out.println();
		
		equips.clear();
	}

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
		}
	}
	
	public void endElement(String uri, String localName, String qName) {
		switch(qName) {
		case "llista-equips":
			llistantEquips = false;
			break;	
		case "nom":
			nomEquip = false;
			break;
		case "partit":
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