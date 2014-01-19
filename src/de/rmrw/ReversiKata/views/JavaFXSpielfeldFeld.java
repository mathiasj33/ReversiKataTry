package de.rmrw.ReversiKata.views;

import de.rmrw.ReversiKata.code.IFSpielModel;
import de.rmrw.ReversiKata.code.SpielfeldFeldZustand;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class JavaFXSpielfeldFeld extends Pane {
	
	private static final double GROESSEABGERUNDETEECKENINPROZENT = 10;
	private static final double PROZENTKREISVONFELD = 85;	

	private int   zeile;
	private int   spalte;
	private JavaFXSpielfeldFeldProperties spielfeldFeldProperties; 
	

	private Rectangle rect = null;
	private Circle kreis = null;

	private IFSpielModel model;

	public JavaFXSpielfeldFeld(IFSpielModel model,
							int zeile,
							int spalte,
							JavaFXSpielfeldFeldProperties properties) {
		super();
		
		this.setMinSize(properties.getPixelSize(), properties.getPixelSize());
		rect = new Rectangle(properties.getPixelSize(), properties.getPixelSize(), properties.getGrundFarbe());
		rect.setArcHeight(GROESSEABGERUNDETEECKENINPROZENT);
		rect.setArcWidth(GROESSEABGERUNDETEECKENINPROZENT);
		rect.setX(0);
		rect.setY(0);
		this.model = model;
		this.zeile = zeile;
		this.spalte = spalte;
		this.spielfeldFeldProperties = properties;
		this.kreis = new Circle(rect.getWidth()/2.0, 
								rect.getHeight()/2.0,
								rect.getWidth()/2.0*PROZENTKREISVONFELD/100, 
								Color.TRANSPARENT);
		this.getChildren().add(rect);
		this.getChildren().add(kreis);
		
		kreis.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				onMousePressed();
			}

		});
		
		kreis.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				onMouseEnter();
			}

		});

		kreis.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				onMouseExited();
			}

		});
		update();
	}

	public void onMousePressed() {
		if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1)
			getModel().besetzeFeld(getZeile(),getSpalte(),1);
		if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
			getModel().besetzeFeld(getZeile(),getSpalte(),2);
	}

	public void onMouseEnter() {
		if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1)
			kreis.setFill(getAngedeuteteFarbeSpieler1());
		if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
			kreis.setFill(getAngedeuteteFarbeSpieler2());
	}

	public void onMouseExited() {
		if (getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR1 ||
			getModel().getFeldZustand(getZeile(),getSpalte())==SpielfeldFeldZustand.LEER_UND_BESETZBAR2)
			kreis.setFill(Color.TRANSPARENT);
	}
	
	
	public JavaFXSpielfeldFeldProperties getSpielfeldFeldProperties() {
		return spielfeldFeldProperties;
	}

	public void setSpielfeldFeldProperties(JavaFXSpielfeldFeldProperties properties) {
		this.spielfeldFeldProperties = properties;
	}

	public Color getAngedeuteteFarbeSpieler1() {
		return spielfeldFeldProperties.getAngedeuteteFarbeSpieler1();
	}

	public Color getAngedeuteteFarbeSpieler2() {
		return spielfeldFeldProperties.getAngedeuteteFarbeSpieler2();
	}

	public Paint getCircleColor() {
		return kreis.getFill();
	}

	public int getZeile() {
		return zeile;
	}

	public int getSpalte() {
		return spalte;
	}

	public IFSpielModel getModel() {
		return model;
	}
	
	public void update() {
		System.out.println("JavaFXSpielfeldFeld.update()");
		SpielfeldFeldZustand zustand = getModel().getFeldZustand(getZeile(),getSpalte());
		if (zustand==SpielfeldFeldZustand.BESETZT1)
			kreis.setFill(spielfeldFeldProperties.getFarbeSpieler1());
		if (zustand==SpielfeldFeldZustand.BESETZT2)
			kreis.setFill(spielfeldFeldProperties.getFarbeSpieler2());
		if (zustand==SpielfeldFeldZustand.LEER_UND_BESETZBAR1 || 
			zustand==SpielfeldFeldZustand.LEER_UND_BESETZBAR2 ||
			zustand==SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR)
			kreis.setFill(Color.TRANSPARENT);
	}


}
