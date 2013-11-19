package configuracionGeneral;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TEMTest {
	
	private TEM tem;

	@Before
	public void setUp() throws Exception {
		tem = new TEM((float) 0.015);
	}

	@Test
	public void testGetTEM() {
		assertEquals(0.015, tem.getTEM(), 0.01);
	}

}
