package de.rmrw.ReversiKata.views;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import de.rmrw.ReversiKata.code.IFSpielModel;

public class JavaFXSpielfeldView extends GridPane {
	
	private IFSpielModel model 							= null;
	private JavaFXSpielfeldFeldProperties properties 	= null;

	public JavaFXSpielfeldView(IFSpielModel model_, JavaFXSpielfeldFeldProperties properties_) {
		super();
		this.setHgap(4);
		this.setVgap(4);
		setModel(model_);
		setSpielfeldFeldProperties(properties_);
	}


	public void init() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				JavaFXSpielfeldFeld feld = 
						createJavaFXSpielfeldFeld(getModel(), i, j, getSpielfeldFeldProperties());
				addFeldToChildren(feld);
				setGridPaneColumnAndRowIndex(i, j, feld);
			}
		}
	}
	
	

	public void setGridPaneColumnAndRowIndex(int i, int j,
			JavaFXSpielfeldFeld feld) {
		GridPane.setColumnIndex(feld, j);
		GridPane.setRowIndex(feld, i);
	}

	public void addFeldToChildren(JavaFXSpielfeldFeld feld) {
		subClassGetChildren().add(feld);
	}

	public JavaFXSpielfeldFeld createJavaFXSpielfeldFeld(IFSpielModel model, int zeile, int spalte,
			JavaFXSpielfeldFeldProperties properties) {
		return new JavaFXSpielfeldFeld(model,         // Modell zum View
								zeile,             
								spalte,             
								properties
								);
	}
	
	public IFSpielModel getModel() {
		return model;
	}



	private void setModel(IFSpielModel model) {
		this.model = model;
	}



	public JavaFXSpielfeldFeldProperties getSpielfeldFeldProperties() {
		return properties;
	}



	private void setSpielfeldFeldProperties(JavaFXSpielfeldFeldProperties properties) {
		this.properties = properties;
	}



	public void update(){
		System.out.println("SpielfeldView.update()");
		for (Node n : subClassGetChildren()) {
			((JavaFXSpielfeldFeld)n).update();
		}
	}


	public ArrayList<Node> subClassGetChildren() {
		ArrayList<Node> al = new ArrayList<Node>();
		al.addAll(super.getChildren());
		return al;
	}

}