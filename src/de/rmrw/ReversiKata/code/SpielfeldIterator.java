package de.rmrw.ReversiKata.code;

public class SpielfeldIterator extends ReversiIterator {
	
	public SpielfeldIterator(Spielfeld spielfeld) {
		for(Pos p : spielfeld.getTreeMap().keySet()) {
			positions.add(p);
		}
	}
	
}
