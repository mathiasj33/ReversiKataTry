package de.rmrw.ReversiKata.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import de.rmrw.ReversiKata.code.Colors;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.ReversiSpiel;
import de.rmrw.ReversiKata.code.ReversiView;
import de.rmrw.ReversiKata.code.Spieler;
import de.rmrw.ReversiKata.code.Spielfeld;

public class SpielTest {

	private ArrayList<ReversiView> views = null;
	private ReversiView mockView1 = null;
	private ReversiView mockView2 = null;
	private ReversiSpiel reversi1 = null;
	private Spieler spieler1 = null;
	private Spieler spieler2 = null;
	
	@Before
	public void setUp() throws Exception {
		views = new ArrayList<ReversiView>();
		mockView1 = mock(ReversiView.class);
		views.add(mockView1);
		mockView2 = mock(ReversiView.class);
		views.add(mockView2);
		reversi1 = new ReversiSpiel(8,views); // besetzt die mittleren Felder und ruft schon 1mal update für alle Views auf
	}

	private void registriereSpieler() {
		spieler1 = reversi1.registriereSpieler("Mathi");  // ruft update für alle Views auf
		spieler2 = reversi1.registriereSpieler("Robert"); // ruft update für alle Views auf
	}

	@Test
	public final void testInitialisierung() {
		Mockito.verify(mockView1).update();
		Mockito.verify(mockView2).update();
	}
	
	@Test
	public final void testRegistriereSpieler() {
		registriereSpieler();
		Mockito.verify(mockView1, times(3)).update();
		Mockito.verify(mockView2, times(3)).update();
		Assert.assertEquals("Mathi", spieler1.getName());
		Assert.assertEquals(Colors.WHITE, spieler1.getColor());
		Assert.assertEquals("Robert", spieler2.getName());
		Assert.assertEquals(Colors.BLACK, spieler2.getColor());
		Assert.assertEquals(spieler1,reversi1.spielerAmZug());
	}

	
	@Test
	public final void testWoKann() {
		registriereSpieler();
		
		Spielfeld mockSpielfeld = mock(Spielfeld.class);
		ReversiSpiel spyReversi = spy(reversi1);
		doReturn(mockSpielfeld).when(spyReversi).getSpielfeld();
		Set<Pos> setPosWoKann = new HashSet<Pos>();
		setPosWoKann.add(new Pos(2,4)); // Das ist zwar fachlich falsch, zum Abprüfen unten reicht es aber.
		when(mockSpielfeld.woKann(Colors.WHITE)).thenReturn(setPosWoKann);
		
		Set<Pos> setPosWoKannErgebnis=spyReversi.woKann(spieler1);
		Assert.assertEquals(1,setPosWoKannErgebnis.size());
	}


	@Test
	public final void testSetzeSpielstein() {
		registriereSpieler();
		Spielfeld mockSpielfeld = mock(Spielfeld.class);
		ReversiSpiel spyReversi = spy(reversi1);
		doReturn(mockSpielfeld).when(spyReversi).getSpielfeld();
		when(mockSpielfeld.setzeSpielstein(spieler1.getColor(), new Pos(2,4))).thenReturn(true);
		
		spyReversi.setzeSpielstein(spieler1,new Pos(2,4));
		Mockito.verify(mockView1, times(4)).update();
		Mockito.verify(mockView2, times(4)).update();
		Assert.assertEquals(spieler2,spyReversi.spielerAmZug());
	}

}
