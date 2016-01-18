package net.javierjimenez.LligaFutbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {
	
	boolean llistantEquips = false;
	
	boolean nomEquip = false;
	
	HashMap<String, Equip> equips = new HashMap<String, Equip>();
	
	private static List<Equip> lliga = new ArrayList<Equip>();
	
	public void endDocument() throws SAXException {

		for (Equip e : equips.values()){
			
			lliga.add(e);
			
		}
		
		Collections.sort(lliga, new comparatorEquips());
		
		System.out.println("Guanyador " + lliga.get(0).getNom());
	}

	public void startElement(String uri, String localName, String qName, Attributes attr) {
		
		switch(qName) {
		
		case "llista-equips":
			llistantEquips = true;
			break;
		case "nom":
			if (llistantEquips) {
				nomEquip = true;
			}
			break;
		
		}
	}
	
	public void characters(char [] ch, int start, int length) {
		
		if(llistantEquips && nomEquip){
			equips.put(new String (ch, start, length), new Equip(new String (ch, start, length)));
			nomEquip = false;
		}
	}
	
	public void endElement(String uri, String localName, String qName) {
		switch(qName) {
		case "llista-equips":
			llistantEquips = false;
		}
	}
}


//Si ganas: 3 puntos. Si empatas: 1 punto cada uno. Si pierdes: Te comes una mierda.