package de.rmrw.ReversiKata.views;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import de.rmrw.ReversiKata.code.IFSpielModel;

public class JavaFXSpielfeldView extends GridPane {

	public JavaFXSpielfeldView(IFSpielModel model, int pixelSize, Color grundFarbe, Color farbeSpieler1, Color farbeSpieler2, Color angedeuteteFarbeSpieler1, Color angedeuteteFarbeSpieler2) {
		super();
		this.setHgap(4);
		this.setVgap(4);
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				JavaFXSpielfeldFeld feld = 
						new JavaFXSpielfeldFeld(model,         // Modell zum View
												0,             // Zeile
												0,             // Spalte
												pixelSize,            // Groesse
												grundFarbe,    // Grundfarbe
												farbeSpieler1,     // Farbe Spieler1
												farbeSpieler2,     // Farbe Spieler2
												angedeuteteFarbeSpieler1, // Angedeutete Farbe Sp1
												angedeuteteFarbeSpieler2  // Angedeutete Farbe Sp2
												);
				getChildren().add(feld);
				GridPane.setColumnIndex(feld, j);
				GridPane.setRowIndex(feld, i);
			}
		}
	}
	
	public void update(){
		System.out.println("SpielfeldView.update()");
		for (Node n : getChildren()) {
			((JavaFXSpielfeldFeld)n).update();
		}
	}

}