package de.rmrw.ReversiKata.viewsTest;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.rmrw.ReversiKata.code.IFSpielModel;
import de.rmrw.ReversiKata.views.JavaFXSpielView;

public class JavaFXSpielTest {

	private static final Color ANGEDEUTETEFARBESPIELER2 = Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1 = Color.LIGHTBLUE;
	private static final Color FARBESPIELER2 = Color.RED;
	private static final Color FARBESPIELER1 = Color.BLUE;
	private static final Color GRUNDFARBE = Color.BEIGE;
	
	@Test
	public final void testKonstruktor() {
		IFSpielModel mockModel = Mockito.mock(IFSpielModel.class);
		
		JavaFXSpielView spielView = 
				new JavaFXSpielView(mockModel, 
				// Parameter der einzelnen Felder des Spielfelds: 
				50,            		// Pixel-Groesse
				GRUNDFARBE,   		// Grundfarbe
				FARBESPIELER1,    	// Farbe Spieler1
				FARBESPIELER2,     	// Farbe Spieler2
				ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
				ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
				);
		
		Mockito.verify(mockModel).addView(spielView);
		Assert.assertTrue(spielView.getJavaFXSpielfeldView() instanceof GridPane);
		Assert.assertTrue(spielView.getJavaFXSpielerView() instanceof VBox);
		Assert.assertNotNull(spielView.getModel());
	}
}
