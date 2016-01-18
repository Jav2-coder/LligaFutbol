package net.javierjimenez.LligaFutbol;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {
	
	int numelements = 0;

	boolean llistantEquips = false;
	
	public void endDocument() throws SAXException {

		System.out.println("Total etiquetes: " + numelements);
	}

	public void startElement(String uri, String localName, String qName, Attributes attr) {
		
		switch(qName) {
		
		case "llista-equips":
			llistantEquips = true;
			break;
		case "nom":
			if (llistantEquips) {
				numelements++;
			}
			break;
		
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