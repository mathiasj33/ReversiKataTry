package de.rmrw.ReversiKata.code;

public class LineIterator extends ReversiIterator {
	
	public LineIterator(Spielfeld spielfeld, Pos startPos, Pos dirPos) {
		positions.add(startPos);
		while(spielfeld.contains(startPos)) {
			startPos = startPos.add(dirPos);
			positions.add(startPos);
		}
	}

}
