package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ReversiIterator implements Iterator<Pos> {
	
	protected ArrayList<Pos> positions = new ArrayList<Pos>();
	private int currentNumber = 0;
	

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
