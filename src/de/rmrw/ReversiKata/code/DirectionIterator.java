package de.rmrw.ReversiKata.code;

public class DirectionIterator extends ReversiIterator {
	
	public DirectionIterator(Pos p, Spielfeld s) {
		Pos[] directions = new Pos[] {
				new Pos(0, 1),new Pos(0,-1),new Pos(1, 0),new Pos(- 1, 0),new Pos(1, 1),new Pos(1,- 1),new Pos( - 1, 1),new Pos(- 1, - 1)
		};
		for(int i = 0; i < directions.length; i++) {
			if(s.contains(p.add(directions[i]))) {
				positions.add(directions[i]);
			}
		}
	}
}
