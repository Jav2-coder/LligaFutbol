package net.javierjimenez.LligaFutbol;

import java.io.IOException;
import java.io.InputStream;

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

	/**
	 * Array de String que contenen el directori i fitxer de cada xml.
	 */
	private static String[] FITXERS = { "/lligaR-1.xml", "/lligaR-2.xml", "/lligaR-3.xml" };

	/**
	 * Metode principal que llegeix la informacio dels arxius xml mitjançant un
	 * parser.
	 * 
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory spf = SAXParserFactory.newInstance();

		SAXParser parser = spf.newSAXParser();

		for (String fitxer : FITXERS) {

			InputStream File = App.class.getResourceAsStream(fitxer);

			parser.parse(File, new Processar());

		}
	}
}