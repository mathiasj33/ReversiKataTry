package de.rmrw.ReversiKata.test;

import java.util.ArrayList;
import java.util.Iterator;

import de.rmrw.ReversiKata.code.LineIterator;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class LineIteratorStub extends LineIterator {

	private ArrayList<Pos> ar;
	private Iterator<Pos> it;
	public LineIteratorStub(Spielfeld spielfeld, Pos startPos, Pos dirPos) {
		super(spielfeld, startPos, dirPos);
		ar = new ArrayList<Pos>();
		ar.add(new Pos(0,0));
		ar.add(new Pos(0,1));
		ar.add(new Pos(0,2));
		it = ar.iterator();
	}

	
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Pos next() {
		return it.next();
	}

}
