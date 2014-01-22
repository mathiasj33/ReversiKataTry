package de.rmrw.ReversiKata.viewsTest;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javafx.scene.paint.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.code.IFSpielModel;
import de.rmrw.ReversiKata.code.SpielfeldFeldZustand;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldProperties;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldView;


public class JavaFXSpielfeldFeldTest {
	
	private static final Color ANGEDEUTETEFARBESPIELER2		= Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1		= Color.LIGHTBLUE;
	private static final Color FARBESPIELER2				= Color.RED;
	private static final Color FARBESPIELER1				= Color.BLUE;
	private static final Color GRUNDFARBE					= Color.BEIGE;
	
	private JavaFXSpielfeldFeldView 			feld 					= null;
	private JavaFXSpielfeldFeldProperties 	spielfeldFeldProperties = null;
	private IFSpielModel 					mockModel 				= null;
	
	@Before
	public void setUp() throws Exception {
		mockModel = mock(IFSpielModel.class);
		spielfeldFeldProperties = new JavaFXSpielfeldFeldProperties(50,            // Groesse
																	GRUNDFARBE,   // Grundfarbe
																	FARBESPIELER1,    // Farbe Spieler1
																	FARBESPIELER2,     // Farbe Spieler2
																	ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
																	ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
																	);
		feld = new JavaFXSpielfeldFeldView(mockModel,     // Modell zum View
										0,             // Zeile
										0,             // Spalte
										spielfeldFeldProperties
										);
	}

	@Test
	public final void testKonstruktor() {
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());
	}
	
	@Test
	public final void testOnMouseEnterAndExit() {
		feld.onMouseEntered();
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());
		feld.onMouseExited();
		
		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR1);
		feld.update();
		feld.onMouseEntered();
		Assert.assertEquals(ANGEDEUTETEFARBESPIELER1, feld.getCircleColor());
		feld.onMouseExited();
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());

		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		feld.update();
		feld.onMouseEntered();
		Assert.assertEquals(ANGEDEUTETEFARBESPIELER2, feld.getCircleColor());
		feld.onMouseExited();
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());

		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.BESETZT1);
		feld.update();
		Assert.assertEquals(FARBESPIELER1, feld.getCircleColor());
		feld.onMouseEntered();
		Assert.assertEquals(FARBESPIELER1, feld.getCircleColor());
		feld.onMouseExited();
		Assert.assertEquals(FARBESPIELER1, feld.getCircleColor());
	}
	
	@Test
	public final void testOnMousePressed() {
		feld.onMousePressed();
		verify(mockModel, times(0)).besetzeFeld(anyInt(),anyInt(),anyInt());
		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		feld.update();
		feld.onMousePressed();
		verify(mockModel).besetzeFeld(0,0,2);
	}
	
}
