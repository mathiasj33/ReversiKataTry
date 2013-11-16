package de.rmrw.ReversiKata.test;

import de.rmrw.ReversiKata.code.Colors;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class SpielfeldFactory {
	
	private static Spielfeld sp;
	
	public static Spielfeld getSpielfeld2x2ForTestGetColorAndForToString() {
		sp = new Spielfeld(2);
		sp.setForInit(Colors.BLACK, new Pos(0,0));
		sp.setForInit(Colors.VOID, new Pos(1,0));
		sp.setForInit(Colors.WHITE, new Pos(1,1));
		return sp;
	}
	
	public static Spielfeld getSpielfeld2x2ForWoKannSchwarz() {
		// b  w
		// o  o
		sp = new Spielfeld(2);
		sp.setForInit(Colors.BLACK, new Pos(0,0));
		sp.setForInit(Colors.WHITE, new Pos(0,1));
		return sp;
	}
	
	public static Spielfeld getSpielfeld3x3ForEsGibtEinenWegVonPosZuFarbeHorizontal() {
		//o  o  o
		//o  w  b
		//o  o  o
		sp = new Spielfeld(3);
		sp.setForInit(Colors.BLACK, new Pos(1,1));
		sp.setForInit(Colors.WHITE, new Pos(1,2));
		return sp;
	}
	
	public static Spielfeld getSpielfeld4x4ForEsGibtEinenWegVonPosZuFarbeHorizontal2() {
		//o  o  o  o
		//o  w  b  o
		//o  o  o  o
		//o  o  o  o
		sp = new Spielfeld(4);
		sp.setForInit(Colors.WHITE, new Pos(1,1));
		sp.setForInit(Colors.BLACK, new Pos(1,2));
		return sp;
	}

	public static Spielfeld getSpielfeld4x4ForEsGibtEinenWegVonPosZuFarbeVertikal() {
		sp = new Spielfeld(4);
		sp.setForInit(Colors.BLACK, new Pos(3,3));
		sp.setForInit(Colors.WHITE, new Pos(3,2));
		sp.setForInit(Colors.WHITE, new Pos(3,1));
		return sp;
	}

	public static Spielfeld getSpielfeld4x4ForEsGibtEinenWegVonPosZuFarbeDiagonal() {
		sp = new Spielfeld(4);
		sp.setForInit(Colors.BLACK, new Pos(3,0));
		sp.setForInit(Colors.WHITE, new Pos(2,1));
		sp.setForInit(Colors.WHITE, new Pos(1,2));
		return sp;
	}

	public static Spielfeld getSpielfeld2x2ForContains() {
		sp = new Spielfeld(2);
		return sp;
	}
}
