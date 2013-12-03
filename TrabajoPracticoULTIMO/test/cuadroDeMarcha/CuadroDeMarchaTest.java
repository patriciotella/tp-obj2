package cuadroDeMarcha;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;

public class CuadroDeMarchaTest {
	
	private CuadroDeMarcha cdm;
	private ToHTML html;
	private ToXML xml;
	private Prestamo p;

	@Before
	public void setUp() throws Exception {
		cdm = new CuadroDeMarcha();
		html = mock(ToHTML.class);
		xml = mock(ToXML.class);
		p = mock (Prestamo.class);
	}

	@Test
	public void testSetConverter() {
		Converter cAux = cdm.getConverter();
		cdm.setConverter(html);
		assertNotSame(cAux, cdm.getConverter());
	}

	@Test
	public void testLoadFileToXML() {
		cdm.setConverter(xml);
		cdm.exportarCuadro(p);
		verify(xml).loadFile(p);
	}	
	
	@Test
	public void testLoadFileToHTML() {
		cdm.setConverter(html);
		cdm.exportarCuadro(p);
		verify(html).loadFile(p);
	}

}
