package de.rmrw.ReversiKata.test;

import de.rmrw.ReversiKata.code.Colors;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class SpielfeldFactory {
	
	private static Spielfeld sp;
	
	public static Spielfeld getSpielfeldForTestGetColorAndForToString() {
		sp = new Spielfeld(3);
		sp.setForInit(Colors.BLACK, new Pos(0,1));
		sp.setForInit(Colors.VOID, new Pos(0,0));
		sp.setForInit(Colors.WHITE, new Pos(0,2));
		return sp;
	}
	
	public static Spielfeld getSpielfeldForWoKannSchwarz() {
		// b  w  w
		// o  o  o
		//(b) o (b)
		sp = new Spielfeld(3);
		sp.setForInit(Colors.BLACK, new Pos(0,0));
		sp.setForInit(Colors.WHITE, new Pos(1,0));
		sp.setForInit(Colors.WHITE, new Pos(2,0));
		return sp;
	}
	
	public static Spielfeld getSpielfeldForEsGibtEinenWegVonPosZufarbe() {
		// b  w  w
		// w  w  o
		//(b) o (b)
		sp = new Spielfeld(3);
		sp.setForInit(Colors.BLACK, new Pos(0,0));
		sp.setForInit(Colors.WHITE, new Pos(1,0));
		sp.setForInit(Colors.WHITE, new Pos(2,0));
		sp.setForInit(Colors.WHITE, new Pos(0,1));
		sp.setForInit(Colors.WHITE, new Pos(1,1));
		return sp;
	}
	
	public static Spielfeld getSpielfeldForContains() {
		sp = new Spielfeld(2);
		return sp;
	}
}
