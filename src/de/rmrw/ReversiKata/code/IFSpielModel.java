package de.rmrw.ReversiKata.code;

import de.rmrw.ReversiKata.code.SpielfeldFeldZustand;
import de.rmrw.ReversiKata.views.IFSpielView;

public interface IFSpielModel {
	public void besetzeFeld(int zeile, int spalte, int spielerNummer);

	public SpielfeldFeldZustand getFeldZustand(int zeile, int spalte);
	
	public void addView(IFSpielView view);
}
