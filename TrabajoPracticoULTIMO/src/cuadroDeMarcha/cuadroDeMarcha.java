package cuadroDeMarcha;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import prestamo.Prestamo;

public class cuadroDeMarcha {
	
	private ToHTML html;
	private ToXML xml;
	
	public void exportarEnHTML(Prestamo p) throws IOException {
		this.html = new ToHTML(p);
		html.loadFile();
	}
	
	public void exportarEnXML(Prestamo p) throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException {
		this.xml = new ToXML(p);
		xml.loadFile();
	}

}
