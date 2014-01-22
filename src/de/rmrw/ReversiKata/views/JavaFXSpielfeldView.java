package de.rmrw.ReversiKata.views;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import de.rmrw.ReversiKata.code.IFSpielModel;
import de.rmrw.ReversiKata.code.SpielfeldFeldZustand;

public class JavaFXSpielfeldView extends GridPane {
	
	private IFSpielModel model 							= null;
	private JavaFXSpielfeldFeldProperties properties 	= null;

	public JavaFXSpielfeldView(IFSpielModel model_, JavaFXSpielfeldFeldProperties properties_) {
		super();
		this.setHgap(4);
		this.setVgap(4);
		setModel(model_);
		setSpielfeldFeldProperties(properties_);
		init();
	}


	public void init() {
		for(int i = 0; i < model.getSize(); i++) {
			for(int j = 0; j < model.getSize(); j++) {
				JavaFXSpielfeldFeldView feld = 
						createJavaFXSpielfeldFeldView(getModel(), i, j, getSpielfeldFeldProperties());
				addFeldToChildren(feld);
				setGridPaneColumnAndRowIndex(i, j, feld);
			}
		}
	}
	
	public JavaFXSpielfeldFeldView createJavaFXSpielfeldFeldView(IFSpielModel model, int i, int j, JavaFXSpielfeldFeldProperties props) {
		return new JavaFXSpielfeldFeldView(model, i, j, props);
	}
	
	

	public void setGridPaneColumnAndRowIndex(int i, int j,
			JavaFXSpielfeldFeld feld) {
		GridPane.setColumnIndex(feld, j);
		GridPane.setRowIndex(feld, i);
	}

	public void addFeldToChildren(JavaFXSpielfeldFeld feld) {
		subClassGetChildren().add(feld);
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
			((JavaFXSpielfeldFeldView)n).update();
		}
	}


	public ArrayList<Node> subClassGetChildren() {
		ArrayList<Node> al = new ArrayList<Node>();
		al.addAll(super.getChildren());
		return al;
	}
	
	public class MouseHandler implements EventHandler<MouseEvent> {
		
		private JavaFXSpielfeldFeld f;
		
		public MouseHandler(JavaFXSpielfeldFeld f_) {
			f = f_;
		}
		
		@Override
		public void handle(MouseEvent e) {
			if(e.getEventType() == MouseEvent.MOUSE_PRESSED) {
				if (getModel().getFeldZustand(f.getZeile(),f.getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1)
					getModel().besetzeFeld(f.getZeile(),f.getSpalte(),1);
				if (getModel().getFeldZustand(f.getZeile(),f.getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
					getModel().besetzeFeld(f.getZeile(),f.getSpalte(),2);
			}
			else if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				if (getModel().getFeldZustand(f.getZeile(),f.getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1)
					f.setKreisFill(f.getAngedeuteteFarbeSpieler1());
				if (getModel().getFeldZustand(f.getZeile(),f.getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
					f.setKreisFill(f.getAngedeuteteFarbeSpieler2());
			}
			else {
				if (getModel().getFeldZustand(f.getZeile(),f.getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1 ||
						getModel().getFeldZustand(f.getZeile(),f.getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
						f.setKreisFill(Color.TRANSPARENT);
			}
		}	
	}
}