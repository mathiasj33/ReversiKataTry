package de.rmrw.ReversiKata.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import de.rmrw.ReversiKata.code.LineIterator;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class LineIteratorStub3x3Directions0_1and1_1 extends LineIterator {

	static private ArrayList<Pos> arHorizontal = new ArrayList<Pos>();
	static private ArrayList<Pos> arDiagonal = new ArrayList<Pos>();
	static private ArrayList<Pos> arVertikal = new ArrayList<Pos>();

	static {
		arHorizontal.addAll(Arrays.asList(new Pos[]{new Pos(0,0),new Pos(0,1),new Pos(0,2) }));
		arDiagonal.addAll(  Arrays.asList(new Pos[]{new Pos(0,0),new Pos(1,1),new Pos(2,2) }));
		arVertikal.addAll(  Arrays.asList(new Pos[]{new Pos(0,0),new Pos(1,0),new Pos(2,0) }));
	}
	
	private ArrayList<Pos> ar = new ArrayList<Pos>();
	private Iterator<Pos> it;
	public LineIteratorStub3x3Directions0_1and1_1(Spielfeld spielfeld, Pos startPos, Pos dirPos) {
		super(spielfeld, startPos, dirPos);
		if (dirPos.equals(new Pos(0,1)))
			ar=arHorizontal;
		else if(dirPos.equals(new Pos(1,1)))
			ar=arDiagonal;
		
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
