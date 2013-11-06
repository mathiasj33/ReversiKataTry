package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Iterator;

public class ReversiIterator implements Iterator<Pos> {
	
	private ArrayList<Pos> positions = new ArrayList<Pos>();
	private int currentNumber = 0;

	public ReversiIterator(Spielfeld spielfeld) {
		for(Pos p : spielfeld.getAllPositionsSorted()) {
			positions.add(p);
		}
	}
	
	public ReversiIterator(Spielfeld spielfeld, Pos pos) {
		if(!spielfeld.contains(pos)) throw new RuntimeException("Pos nicht enthalten");
		Pos[] array = new Pos[] {
			new Pos(pos.getX(), pos.getY() + 1),new Pos(pos.getX(), pos.getY() - 1),new Pos(pos.getX() + 1, pos.getY()),new Pos(pos.getX() - 1, pos.getY()),new Pos(pos.getX() + 1, pos.getY() + 1),new Pos(pos.getX() + 1, pos.getY() - 1),new Pos(pos.getX() - 1, pos.getY() + 1),new Pos(pos.getX() - 1, pos.getY() - 1)
		};
		for(int i = 0; i < 8; i++) {
			if(spielfeld.contains(array[i])) positions.add(array[i]);
		}
	}
	
	public ReversiIterator(Spielfeld spielfeld, Pos startPos, Pos dirPos) {
		positions.add(startPos);
		while(spielfeld.contains(startPos)) {
			startPos = startPos.add(dirPos);
			positions.add(startPos);
		}
	}

	@Override
	public boolean hasNext() {
		if(currentNumber < positions.size()) {
			return true;
		}
		return false;
	}

	@Override
	public Pos next() {
		Pos p =  positions.get(currentNumber);
		currentNumber += 1;
		return p;
	}

	@Override
	public void remove() {
		throw new RuntimeException("wird nicht benotigt und ist deshalb nicht implementiert.");
	}

}
