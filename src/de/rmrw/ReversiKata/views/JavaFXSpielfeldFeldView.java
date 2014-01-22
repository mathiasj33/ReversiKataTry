package de.rmrw.ReversiKata.views;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import de.rmrw.ReversiKata.code.IFSpielModel;
import de.rmrw.ReversiKata.code.SpielfeldFeldZustand;

public class JavaFXSpielfeldFeldView extends JavaFXSpielfeldFeld implements
		IFSpielView {
	
	private IFSpielModel model;
	private JavaFXSpielfeldFeldProperties spielfeldFeldProperties;

	public JavaFXSpielfeldFeldView(IFSpielModel model_, int zeile, int spalte,
			JavaFXSpielfeldFeldProperties properties) {
		super(zeile, spalte, properties);
		setSpielfeldFeldProperties(properties);
		setModel(model_);
		setFeldOnMouseEntered(new MouseHandler());
		setFeldOnMouseExited(new MouseHandler());
		setFeldOnMousePressed(new MouseHandler());
	}
	
	@Override
	public void update() {
		System.out.println("JavaFXSpielfeldFeldView.update()");
		SpielfeldFeldZustand zustand = getModel().getFeldZustand(getZeile(),getSpalte());
		if (zustand==SpielfeldFeldZustand.BESETZT1)
			setKreisFill(spielfeldFeldProperties.getFarbeSpieler1());
		if (zustand==SpielfeldFeldZustand.BESETZT2)
			setKreisFill(spielfeldFeldProperties.getFarbeSpieler2());
		if (zustand==SpielfeldFeldZustand.LEER_UND_BESETZBAR1 || 
			zustand==SpielfeldFeldZustand.LEER_UND_BESETZBAR2 ||
			zustand==SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR)
			setKreisFill(Color.TRANSPARENT);
	}

	public IFSpielModel getModel() {
		return model;
	}

	public void setModel(IFSpielModel model) {
		this.model = model;
	}
	
	public JavaFXSpielfeldFeldProperties getSpielfeldFeldProperties() {
		return spielfeldFeldProperties;
	}

	public void setSpielfeldFeldProperties(
			JavaFXSpielfeldFeldProperties spielfeldFeldProperties) {
		this.spielfeldFeldProperties = spielfeldFeldProperties;
	}
	
public class MouseHandler implements EventHandler<MouseEvent> {
		
		@Override
		public void handle(MouseEvent e) {
			if(e.getEventType() == MouseEvent.MOUSE_PRESSED) {
				onMousePressed();
			}
			else if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				onMouseEntered();
			}
			else {
				onMouseExited();
			}
		}	
	}

public void onMousePressed()  {
	if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1)
		getModel().besetzeFeld(getZeile(),getSpalte(),1);
	if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
		getModel().besetzeFeld(getZeile(),getSpalte(),2);
}

public void onMouseEntered() {
	if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1)
		setKreisFill(getAngedeuteteFarbeSpieler1());
	if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
		setKreisFill(getAngedeuteteFarbeSpieler2());
}

public void onMouseExited() {
	if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1 ||
			getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
			setKreisFill(Color.TRANSPARENT);
}

}
