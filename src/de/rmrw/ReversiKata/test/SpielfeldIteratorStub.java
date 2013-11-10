package de.rmrw.ReversiKata.test;

import java.util.ArrayList;
import java.util.Iterator;

import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;
import de.rmrw.ReversiKata.code.SpielfeldIterator;

public class SpielfeldIteratorStub extends SpielfeldIterator {

	private ArrayList<Pos> ar;
	private Iterator<Pos> it;
	public SpielfeldIteratorStub(Spielfeld spielfeld) {
		super(spielfeld);
		ar = new ArrayList<Pos>();
		ar.add(new Pos(0,0));
		ar.add(new Pos(0,1));
		ar.add(new Pos(1,0));
		ar.add(new Pos(1,1));
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
