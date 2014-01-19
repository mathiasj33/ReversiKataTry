package de.rmrw.ReversiKata.views;

import javafx.scene.paint.Color;

public class JavaFXSpielfeldFeldProperties {
	private int pixelSize;
	private Color grundFarbe;
	private Color farbeSpieler1;
	private Color farbeSpieler2;
	private Color angedeuteteFarbeSpieler1;
	private Color angedeuteteFarbeSpieler2;
	
	
	public JavaFXSpielfeldFeldProperties(int pixelSize, Color grundFarbe,
			Color farbeSpieler1, Color farbeSpieler2,
			Color angedeuteteFarbeSpieler1, Color angedeuteteFarbeSpieler2) {
		super();
		this.pixelSize = pixelSize;
		this.grundFarbe = grundFarbe;
		this.farbeSpieler1 = farbeSpieler1;
		this.farbeSpieler2 = farbeSpieler2;
		this.angedeuteteFarbeSpieler1 = angedeuteteFarbeSpieler1;
		this.angedeuteteFarbeSpieler2 = angedeuteteFarbeSpieler2;
	}
	
	public int getPixelSize() {
		return pixelSize;
	}
	public void setPixelSize(int pixelSize) {
		this.pixelSize = pixelSize;
	}
	public Color getGrundFarbe() {
		return grundFarbe;
	}
	public void setGrundFarbe(Color grundFarbe) {
		this.grundFarbe = grundFarbe;
	}
	public Color getFarbeSpieler1() {
		return farbeSpieler1;
	}
	public void setFarbeSpieler1(Color farbeSpieler1) {
		this.farbeSpieler1 = farbeSpieler1;
	}
	public Color getFarbeSpieler2() {
		return farbeSpieler2;
	}
	public void setFarbeSpieler2(Color farbeSpieler2) {
		this.farbeSpieler2 = farbeSpieler2;
	}
	public Color getAngedeuteteFarbeSpieler1() {
		return angedeuteteFarbeSpieler1;
	}
	public void setAngedeuteteFarbeSpieler1(Color angedeuteteFarbeSpieler1) {
		this.angedeuteteFarbeSpieler1 = angedeuteteFarbeSpieler1;
	}
	public Color getAngedeuteteFarbeSpieler2() {
		return angedeuteteFarbeSpieler2;
	}
	public void setAngedeuteteFarbeSpieler2(Color angedeuteteFarbeSpieler2) {
		this.angedeuteteFarbeSpieler2 = angedeuteteFarbeSpieler2;
	}
}
