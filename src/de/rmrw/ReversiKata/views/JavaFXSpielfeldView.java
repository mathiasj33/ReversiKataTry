package de.rmrw.ReversiKata.views;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import de.rmrw.ReversiKata.code.IFSpielModel;

public class JavaFXSpielfeldView extends GridPane {

	public JavaFXSpielfeldView(IFSpielModel model, JavaFXSpielfeldFeldProperties properties) {
		super();
		this.setHgap(4);
		this.setVgap(4);
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				JavaFXSpielfeldFeld feld = 
						new JavaFXSpielfeldFeld(model,         // Modell zum View
												0,             // Zeile
												0,             // Spalte
												properties
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