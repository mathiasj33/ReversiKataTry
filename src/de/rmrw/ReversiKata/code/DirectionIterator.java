package de.rmrw.ReversiKata.code;

public class DirectionIterator extends ReversiIterator {
	
	public DirectionIterator() {
		Pos[] directions = new Pos[] {
				new Pos(0, 1),new Pos(0,-1),new Pos(1, 0),new Pos(- 1, 0),new Pos(1, 1),new Pos(1,- 1),new Pos( - 1, 1),new Pos(- 1, - 1)
		};
		for(int i = 0; i < directions.length; i++) {
			positions.add(directions[i]);
		}
	}
	
	

}
