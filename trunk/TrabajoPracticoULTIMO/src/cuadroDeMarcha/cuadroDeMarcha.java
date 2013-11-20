package cuadroDeMarcha;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import prestamo.Prestamo;

public class cuadroDeMarcha {
	
	private ToHTML html;
	private ToXML xml;
	
	public void exportarEnHTML(Prestamo p) {
		this.html = new ToHTML(p);
		html.loadFile();
	}
	
	public void exportarEnXML(Prestamo p) throws TransformerFactoryConfigurationError, TransformerException {
		this.xml = new ToXML(p);
		xml.loadFile();
	}

}
