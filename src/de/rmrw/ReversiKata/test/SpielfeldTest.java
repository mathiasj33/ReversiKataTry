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
		spielfeld = SpielfeldFactory.getSpielfeld3x3ForTestGetColorAndForToString();
		Assert.assertEquals(Colors.BLACK, spielfeld.getColor(new Pos(0,1)));
		Assert.assertEquals(Colors.VOID, spielfeld.getColor(new Pos(0,0)));
		Assert.assertEquals(Colors.WHITE, spielfeld.getColor(new Pos(0,2)));
	}
	

	@Test
	public final void testToString() {
		spielfeld = SpielfeldFactory.getSpielfeld3x3ForTestGetColorAndForToString();
		String s = spielfeld.toString();
		Assert.assertEquals("o b w"+System.getProperty("line.separator")+
							"o o o"+System.getProperty("line.separator")+
							"o o o"+System.getProperty("line.separator"),
							s);
	}
	
	@Test
	public void testWoKannSchwarzMitMoeglichkeitAufLeeremFeld() {
		// Partielles Mocking: Methode "woKann" wird getestet, Methode "esGibtEinenWegVonPosZuFarbe" wird gemockt
		Spielfeld spySpielfeld = spy(SpielfeldFactory.getSpielfeld2x2ForWoKannSchwarz());
		//  b  w
		//  o  o
		// Eigentlich geht da gar nix, unser stub fuer esGibtEinenWegVonPosZuFarbe tut aber so, als ob
		//  b  w
		// (b) o
		
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,1),Colors.BLACK);
		doReturn(true).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,1),Colors.BLACK);
		// Mock-Ende;
		
		Set<Pos> ergebnisMenge = spySpielfeld.woKann(Colors.BLACK);
		Assert.assertEquals(1,ergebnisMenge.size());
		Assert.assertTrue(ergebnisMenge.contains(new Pos(1,0))); // Gegenprobe nicht nötig, da nur 1 Element in der Menge
	}
	
	@Test
	public void testWoKannSchwarzMitMoeglichkeitAufBesetzemFeld() {
		// Partielles Mocking: Methode "woKann" wird getestet, Methode "esGibtEinenWegVonPosZuFarbe" wird gemockt
		Spielfeld spySpielfeld = spy(SpielfeldFactory.getSpielfeld2x2ForWoKannSchwarz());
		//  b  w
		//  o  o
		// Eigentlich geht da gar nix, unser stub fuer esGibtEinenWegVonPosZuFarbe tut aber so, als ob bei (0,1) was gehen würde, wenn da kein Stein läge
		//  b  w<-(b)
		//  o  o
		
		doReturn(true).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,1),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,1),Colors.BLACK);
		// Mock-Ende;
		
		Set<Pos> ergebnisMenge = spySpielfeld.woKann(Colors.BLACK);
		Assert.assertEquals(0,ergebnisMenge.size());
	}

	
	@Test
	public void testContains() {
		spielfeld = SpielfeldFactory.getSpielfeld2x2ForContains();
		Assert.assertTrue(spielfeld.contains(new Pos(1,1)));
		Assert.assertFalse(spielfeld.contains(new Pos(2,0)));
	}

	@Test
	public void testEsGibtEinenWegVonPosZuFarbeHorizontal() {
		spielfeld = SpielfeldFactory.getSpielfeld3x3ForEsGibtEinenWegVonPosZuFarbeHorizontal();
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(1,2), Colors.BLACK));
		Assert.assertFalse(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(1,1), Colors.BLACK));
	}

	@Test
	public void testEsGibtEinenWegVonPosZuFarbeVertikal() {
		spielfeld = SpielfeldFactory.getSpielfeld4x4ForEsGibtEinenWegVonPosZuFarbeVertikal();
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(3,0), Colors.BLACK));
		Assert.assertFalse(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(1,1), Colors.BLACK));
	}
	
	@Test
	public void testEsGibtEinenWegVonPosZuFarbeDiagonal() {
		spielfeld = SpielfeldFactory.getSpielfeld4x4ForEsGibtEinenWegVonPosZuFarbeDiagonal();
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(0,3), Colors.BLACK));
		Assert.assertFalse(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(1,1), Colors.BLACK));
	}
	

}
