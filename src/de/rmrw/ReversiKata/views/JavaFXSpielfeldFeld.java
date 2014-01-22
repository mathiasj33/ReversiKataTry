package de.rmrw.ReversiKata.views;

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

	public JavaFXSpielfeldFeld(int zeile,
							int spalte,
							JavaFXSpielfeldFeldProperties properties) {
		super();
		
		this.setMinSize(properties.getPixelSize(), properties.getPixelSize());
		rect = new Rectangle(properties.getPixelSize(), properties.getPixelSize(), properties.getGrundFarbe());
		rect.setArcHeight(GROESSEABGERUNDETEECKENINPROZENT);
		rect.setArcWidth(GROESSEABGERUNDETEECKENINPROZENT);
		rect.setX(0);
		rect.setY(0);
		this.zeile = zeile;
		this.spalte = spalte;
		this.spielfeldFeldProperties = properties;
		this.kreis = new Circle(rect.getWidth()/2.0, 
								rect.getHeight()/2.0,
								rect.getWidth()/2.0*PROZENTKREISVONFELD/100, 
								Color.TRANSPARENT);
		this.getChildren().add(rect);
		this.getChildren().add(kreis);
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
	
	public void setFeldOnMousePressed(EventHandler<MouseEvent> e) {
		kreis.setOnMousePressed(e);
	}
	
	public void setFeldOnMouseEntered(EventHandler<MouseEvent> e) {
		kreis.setOnMouseEntered(e);
	}
	
	public void setFeldOnMouseExited(EventHandler<MouseEvent> e) {
		kreis.setOnMouseExited(e);
	}
	
	public void setKreisFill(Color c) {
		kreis.setFill(c);
	}


}
