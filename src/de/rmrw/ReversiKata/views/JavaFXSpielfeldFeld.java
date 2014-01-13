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
	private Color farbeSpieler1;
	private Color farbeSpieler2;
	private Color angedeuteteFarbeSpieler1;
	private Color angedeuteteFarbeSpieler2;
	
	private Rectangle rect = null;
	private Circle kreis = null;

	private IFSpielModel model;

	public JavaFXSpielfeldFeld(IFSpielModel model,
							int zeile,
							int spalte,
							double groesse,
							Color grundfarbe,
							Color farbeSpieler1,
							Color farbeSpieler2, 
							Color angedeuteteFarbeSpieler1,
							Color angedeuteteFarbeSpieler2) {
		super();
		this.setMinSize(groesse, groesse);
		rect = new Rectangle(groesse, groesse, grundfarbe);
		rect.setArcHeight(GROESSEABGERUNDETEECKENINPROZENT);
		rect.setArcWidth(GROESSEABGERUNDETEECKENINPROZENT);
		rect.setX(0);
		rect.setY(0);
		this.model = model;
		this.zeile = zeile;
		this.spalte = spalte;
		this.farbeSpieler1 = farbeSpieler1;
		this.farbeSpieler2 = farbeSpieler2;
		this.angedeuteteFarbeSpieler1 = angedeuteteFarbeSpieler1;
		this.angedeuteteFarbeSpieler2 = angedeuteteFarbeSpieler2;
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
	
	public Color getAngedeuteteFarbeSpieler1() {
		return angedeuteteFarbeSpieler1;
	}

	public Color getAngedeuteteFarbeSpieler2() {
		return angedeuteteFarbeSpieler2;
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
			kreis.setFill(farbeSpieler1);
		if (zustand==SpielfeldFeldZustand.BESETZT2)
			kreis.setFill(farbeSpieler2);
		if (zustand==SpielfeldFeldZustand.LEER_UND_BESETZBAR1 || 
			zustand==SpielfeldFeldZustand.LEER_UND_BESETZBAR2 ||
			zustand==SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR)
			kreis.setFill(Color.TRANSPARENT);
	}


}
