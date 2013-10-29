package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Iterator;

public class SpielfeldIterator implements Iterator<Pos> {
	
	private ArrayList<Pos> positions = new ArrayList<Pos>();
	private int currentNumber = 0;
	
	public SpielfeldIterator(Spielfeld spielfeld) {
		for(Pos p : spielfeld.getMap().keySet()) {
			positions.add(p);
		}
	}
	
	public boolean hasNext() {
		if(currentNumber < positions.size()) return true;
		return false;
	}
	
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