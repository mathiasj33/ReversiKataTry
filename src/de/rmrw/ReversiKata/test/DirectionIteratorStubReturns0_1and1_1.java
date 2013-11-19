package de.rmrw.ReversiKata.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import de.rmrw.ReversiKata.code.DirectionIterator;
import de.rmrw.ReversiKata.code.Pos;

public class DirectionIteratorStubReturns0_1and1_1 extends DirectionIterator {

	static private ArrayList<Pos> ar;
	private Iterator<Pos> it;
	
	public DirectionIteratorStubReturns0_1and1_1() {
		ar = new ArrayList<Pos>();
		ar.addAll(Arrays.asList(new Pos[]{new Pos(0,1),new Pos(1,1)}));
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
