package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Set;

public class ReversiSpiel {
	
	private ArrayList<ReversiView> views;
	private int size;
	private Spielfeld spielfeld;
	private Spieler spieler1;
	private Spieler spieler2;
	private boolean ersterSpieler = true;
	
	public ReversiSpiel(int size_, ArrayList<ReversiView> views_) {
		views = views_;
		setSize(size_);
		spielfeld = new Spielfeld(getSize());
		getSpielfeld().setForInit(Colors.WHITE, new Pos(3,3));
		getSpielfeld().setForInit(Colors.BLACK, new Pos(4,3));
		getSpielfeld().setForInit(Colors.BLACK, new Pos(3,4));
		getSpielfeld().setForInit(Colors.WHITE, new Pos(4,4)); 
		updateAllViews();
	}

	private void updateAllViews() {
		for(ReversiView v : views) {
			v.update();
		}	
	}
	
	public Spieler registriereSpieler(String name) {
		if(ersterSpieler) {
			spieler1 = new Spieler(name, Colors.WHITE, true);
			ersterSpieler = false;
			updateAllViews();
			return spieler1;
		}
		spieler2 = new Spieler(name, Colors.BLACK, false);
		updateAllViews();
		return spieler2;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Spielfeld getSpielfeld() {
		return spielfeld;
	}
	
	public Set<Pos> woKann(Spieler s) {
		return getSpielfeld().woKann(s.getColor());
	}
	
	public void setzeSpielstein(Spieler s, Pos p) {
		getSpielfeld().setzeSpielstein(s.getColor(), p);
		updateAllViews();
		if(spieler1.isAmZug()) {
			spieler2.setAmZug(true);
			spieler1.setAmZug(false);
		} else {
			spieler1.setAmZug(true);
			spieler2.setAmZug(false);
		}
	}
	
	public Spieler spielerAmZug() {
		if(spieler1.isAmZug()) return spieler1;
		return spieler2;
	}

}
