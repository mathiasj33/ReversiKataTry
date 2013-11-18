package de.rmrw.ReversiKata.code;

public class LineIterator extends ReversiIterator {
	
	public LineIterator(Spielfeld spielfeld, Pos startPos, Pos dirPos) {
		Pos p = startPos;
		while(spielfeld.contains(p)) {
			positions.add(p);
			p = p.add(dirPos);
		}
	}

}
