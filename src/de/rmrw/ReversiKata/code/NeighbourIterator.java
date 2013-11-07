package de.rmrw.ReversiKata.code;

public class NeighbourIterator extends ReversiIterator {
	
	public NeighbourIterator(Spielfeld spielfeld, Pos pos) {
		if(!spielfeld.contains(pos)) throw new RuntimeException("Pos nicht enthalten");
		Pos[] array = new Pos[] {
			new Pos(pos.getX(), pos.getY() + 1),new Pos(pos.getX(), pos.getY() - 1),new Pos(pos.getX() + 1, pos.getY()),new Pos(pos.getX() - 1, pos.getY()),new Pos(pos.getX() + 1, pos.getY() + 1),new Pos(pos.getX() + 1, pos.getY() - 1),new Pos(pos.getX() - 1, pos.getY() + 1),new Pos(pos.getX() - 1, pos.getY() - 1)
		};
		for(int i = 0; i < 8; i++) {
			if(spielfeld.contains(array[i])) positions.add(array[i]);
		}
	}

}
