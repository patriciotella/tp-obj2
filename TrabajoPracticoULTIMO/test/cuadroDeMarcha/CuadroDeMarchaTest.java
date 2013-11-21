package cuadroDeMarcha;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuadroDeMarchaTest {
	
	private cuadroDeMarcha cdm;
	private ToHTML html;
	private ToXML xml;
	private Prestamo p;

	@Before
	public void setUp() throws Exception {
		cdm = new cuadroDeMarcha();
		html = mock(ToHTML.class);
		xml = mock(ToXML.class);
	}

	@Test
	public void testExportarEnHTML() {
		fail("Not yet implemented");
	}

	@Test
	public void testExportarEnXML() {
		fail("Not yet implemented");
	}

}
