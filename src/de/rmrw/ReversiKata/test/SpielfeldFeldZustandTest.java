package de.rmrw.ReversiKata.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.code.SpielfeldFeldZustand;

public class SpielfeldFeldZustandTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testGetName() {
		Assert.assertEquals(SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR, SpielfeldFeldZustand.getZustandFromString("Leer und nicht besetzbar"));
	}

}
