package exportable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;

public class ToXMLTest {
	
	private Exportable e;
	private Prestamo p;

	@Before
	public void setUp() throws Exception {
		p = mock(Prestamo.class);
		e = new ToXML(p);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
