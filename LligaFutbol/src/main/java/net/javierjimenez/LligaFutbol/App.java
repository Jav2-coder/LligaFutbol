package net.javierjimenez.LligaFutbol;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 
 * @author alumne1daw
 *
 */
public class App {

	private static String FITXER = "/lligaR-1.xml";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		SAXParser parser = spf.newSAXParser();
		
		parser.parse(new File(App.class.getResource(FITXER).getFile()), new Processar());
	}
}