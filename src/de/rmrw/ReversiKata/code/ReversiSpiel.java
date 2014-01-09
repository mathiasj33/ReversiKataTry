package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Set;

public class ReversiSpiel {
	
	private ArrayList<IFReversiView> views;
	private int size;
	private Spielfeld spielfeld;
	private Spieler spieler1;
	private Spieler spieler2;
	private boolean ersterSpieler = true;
	
	public ReversiSpiel(int size_, ArrayList<IFReversiView> views_) {
		views = views_;
		setSize(size_);
		spielfeld = new Spielfeld(getSize());
	}

	public void initSpiel() {
		getSpielfeld().setForInit(Colors.WHITE, new Pos(getSize()/2-1,getSize()/2-1));
		getSpielfeld().setForInit(Colors.BLACK, new Pos(getSize()/2,getSize()/2-1));
		getSpielfeld().setForInit(Colors.BLACK, new Pos(getSize()/2-1,getSize()/2));
		getSpielfeld().setForInit(Colors.WHITE, new Pos(getSize()/2,getSize()/2));
		updateAllViews();
	}

	private void updateAllViews() {
		for(IFReversiView v : views) {
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
		if(spieler1.isAmZug() && getSpielfeld().woKann(spieler2.getColor()).size()!=0) {
			spieler2.setAmZug(true);
			spieler1.setAmZug(false);
		} 
		else if(spieler2.isAmZug() && getSpielfeld().woKann(spieler1.getColor()).size()!=0) {
			spieler1.setAmZug(true);
			spieler2.setAmZug(false);
		}
	}
	
	public Spieler spielerAmZug() {
		if(spieler1.isAmZug()) return spieler1;
		return spieler2;
	}

}
