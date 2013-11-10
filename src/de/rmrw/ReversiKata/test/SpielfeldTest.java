package de.rmrw.ReversiKata.test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.code.Colors;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class SpielfeldTest {
	
	private Spielfeld spielfeld; 

	@Before
	public void setUp() throws Exception {
		// Spalte:       0  1  2  3
		//
		// Zeile 0:      o  o  o  b
		// Zeile 1:     (b)(b) w  b
		// Zeile 2:      o  w  o  w
		// Zeile 3:     (b) o  b (b)
		//
		
		spielfeld = new Spielfeld(4); // 4x4-Spielfeld
		spielfeld.setForInit(Colors.BLACK,new Pos(0,3));
		spielfeld.setForInit(Colors.WHITE,new Pos(1,2));
		spielfeld.setForInit(Colors.BLACK,new Pos(1,3));
		spielfeld.setForInit(Colors.WHITE,new Pos(2,1));
		spielfeld.setForInit(Colors.WHITE,new Pos(2,3));
		spielfeld.setForInit(Colors.BLACK,new Pos(3,2));
	}
	
	@Test 
	public final void testGetColor() {
		Assert.assertEquals(Colors.VOID, spielfeld.getColor(new Pos(0,1)));
		Assert.assertEquals(Colors.VOID, spielfeld.getColor(new Pos(2,2)));
		Assert.assertEquals(Colors.BLACK, spielfeld.getColor(new Pos(0,3)));
		Assert.assertEquals(Colors.WHITE, spielfeld.getColor(new Pos(2,1)));
	}
	

	@Test
	public final void testToString() {
		String s = spielfeld.toString();
		Assert.assertEquals("o o o b"+System.getProperty("line.separator")+
							"o o w b"+System.getProperty("line.separator")+
							"o w o w"+System.getProperty("line.separator")+
							"o o b o"+System.getProperty("line.separator"),
							s);
	}
	
	@Test
	public void testWoKannSchwarz() {
		// Partielles Mocking: Methode "woKann" wird getestet, Methode "esGibtEinenWegVonPosZuFarbe" wird gemockt
		Spielfeld spySpielfeld = spy(spielfeld);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,1),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,2),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(0,3),Colors.BLACK);
		doReturn(true ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,0),Colors.BLACK);
		doReturn(true ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,1),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,2),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(1,3),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,0),Colors.BLACK);
		doReturn(true ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,1),Colors.BLACK); // korrigiert von false auf true, Robert 29.10.
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,2),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(2,3),Colors.BLACK);
		doReturn(true ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(3,0),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(3,1),Colors.BLACK);
		doReturn(false).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(3,2),Colors.BLACK);
		doReturn(true ).when(spySpielfeld).esGibtEinenWegVonPosZuFarbe(new Pos(3,3),Colors.BLACK);
		// Mock-Ende;
		
		Set<Pos> ergebnisMenge = spySpielfeld.woKann(Colors.BLACK);
		Assert.assertEquals(4,ergebnisMenge.size());
		Assert.assertTrue(ergebnisMenge.contains(new Pos(1,0)));
		Assert.assertTrue(ergebnisMenge.contains(new Pos(1,1)));
		Assert.assertTrue(ergebnisMenge.contains(new Pos(3,0)));
		Assert.assertTrue(ergebnisMenge.contains(new Pos(3,3)));
		Assert.assertFalse(ergebnisMenge.contains(new Pos(3,2)));
		Assert.assertFalse(ergebnisMenge.contains(new Pos(2,1))); // hinzugefügt, Robert 29.10.
	}
	
	@Test
	public void testContains() {
		Assert.assertTrue(spielfeld.contains(new Pos(3,1)));
		Assert.assertFalse(spielfeld.contains(new Pos(4,0)));
	}

	
	// Spalte:       0  1  2  3
	//
	// Zeile 0:      o  o  o  b
	// Zeile 1:     (b)(b) w  b
	// Zeile 2:      o  w  o  w
	// Zeile 3:     (b) o  b (b)
	//

	@Test
	public void testEsGibtEinenWegVonPosZuFarbe() {
		Assert.assertFalse(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(0,2),Colors.BLACK));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(1,0),Colors.BLACK));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(3,0),Colors.BLACK));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(2,1),Colors.BLACK)); 
		Assert.assertFalse(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(3,1),Colors.BLACK));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(3,3),Colors.BLACK));
		spielfeld.setForInit(Colors.WHITE,new Pos(3,3));
		Assert.assertTrue(spielfeld.esGibtEinenWegVonPosZuFarbe(new Pos(3,1),Colors.WHITE));
		
	}
}
