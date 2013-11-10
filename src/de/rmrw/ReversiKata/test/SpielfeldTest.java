package de.rmrw.ReversiKata.test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import de.rmrw.ReversiKata.code.Colors;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class SpielfeldTest {
	
	private Spielfeld spielfeld; 
	
	@Test 
	public final void testGetColor() {
		spielfeld = SpielfeldFactory.getSpielfeldForTestGetColorAndForToString();
		Assert.assertEquals(Colors.BLACK, spielfeld.getColor(new Pos(0,1)));
		Assert.assertEquals(Colors.VOID, spielfeld.getColor(new Pos(0,0)));
		Assert.assertEquals(Colors.WHITE, spielfeld.getColor(new Pos(0,2)));
	}
	

	@Test
	public final void testToString() {
		spielfeld = SpielfeldFactory.getSpielfeldForTestGetColorAndForToString();
		String s = spielfeld.toString();
		Assert.assertEquals("o b w"+System.getProperty("line.separator")+
							"o o o"+System.getProperty("line.separator")+
							"o o o"+System.getProperty("line.separator"),
							s);
	}
	
	@Test
	public void testWoKannSchwarz() {
		// Partielles Mocking: Methode "woKann" wird getestet, Methode "esGibtEinenWegVonPosZuFarbe" wird gemockt
		Spielfeld spySpielfeld = spy(SpielfeldFactory.getSpielfeldForWoKannSchwarz());
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,1),Colors.BLACK);
		doReturn(true).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,2),Colors.BLACK);
		doReturn(false ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,1),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,2),Colors.BLACK);
		doReturn(true).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,0),Colors.BLACK);
		doReturn(false ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,1),Colors.BLACK);
		doReturn(true).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,2),Colors.BLACK);
		// Mock-Ende;
		
		Set<Pos> ergebnisMenge = spySpielfeld.woKann(Colors.BLACK);
		Assert.assertEquals(2,ergebnisMenge.size());
		Assert.assertTrue(ergebnisMenge.contains(new Pos(0,2)));
		Assert.assertTrue(ergebnisMenge.contains(new Pos(2,2)));
	}
	
	@Test
	public void testContains() {
		spielfeld = SpielfeldFactory.getSpielfeldForContains();
		Assert.assertTrue(spielfeld.contains(new Pos(1,1)));
		Assert.assertFalse(spielfeld.contains(new Pos(2,0)));
	}

	@Test
	public void testEsGibtEinenWegVonPosZuFarbe() {
		spielfeld = SpielfeldFactory.getSpielfeldForEsGibtEinenWegVonPosZufarbe();
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(0,2), Colors.BLACK));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(2,0), Colors.BLACK));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(2,2), Colors.BLACK));
	}
}
