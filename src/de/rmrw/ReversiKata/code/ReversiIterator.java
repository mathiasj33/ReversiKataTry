package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Iterator;

public class ReversiIterator implements Iterator<Pos> {
	
	private ArrayList<Pos> positions = new ArrayList<Pos>();
	private int currentNumber = 0;

	public ReversiIterator(Spielfeld spielfeld) {
		for(Pos p : spielfeld.getMap().keySet()) {
			positions.add(p);
		}
	}
	
	public ReversiIterator(Spielfeld spielfeld, Pos pos) {
		if(!spielfeld.contains(pos)) throw new RuntimeException("Pos nicht enthalten");
		for(int i = 0; i < 8; i++) {
			switch(i) {
			case 0: {
				if(spielfeld.contains(new Pos(pos.getX(), pos.getY() + 1))) positions.add(new Pos(pos.getX(), pos.getY() + 1));
			}
			case 1: {
				if(spielfeld.contains(new Pos(pos.getX(), pos.getY() - 1))) positions.add(new Pos(pos.getX(), pos.getY() - 1));
			}
			case 2: {
				if(spielfeld.contains(new Pos(pos.getX() + 1, pos.getY()))) positions.add(new Pos(pos.getX() + 1, pos.getY()));
			}
			case 3: {
				if(spielfeld.contains(new Pos(pos.getX() - 1, pos.getY()))) positions.add(new Pos(pos.getX() - 1, pos.getY()));
			}
			case 4: {
				if(spielfeld.contains(new Pos(pos.getX() + 1, pos.getY() + 1))) positions.add(new Pos(pos.getX() + 1, pos.getY() + 1));
			}
			case 5: {
				if(spielfeld.contains(new Pos(pos.getX() + 1, pos.getY() - 1))) positions.add(new Pos(pos.getX() + 1, pos.getY() - 1));
			}
			case 6: {
				if(spielfeld.contains(new Pos(pos.getX() - 1, pos.getY() + 1))) positions.add(new Pos(pos.getX() - 1, pos.getY() + 1));
			}
			case 7: {
				if(spielfeld.contains(new Pos(pos.getX() - 1, pos.getY() - 1))) positions.add(new Pos(pos.getX() - 1, pos.getY() - 1));
			}
			}
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
