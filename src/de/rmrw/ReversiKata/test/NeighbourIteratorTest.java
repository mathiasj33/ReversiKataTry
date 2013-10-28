package de.rmrw.ReversiKata.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.code.Colors;
import de.rmrw.ReversiKata.code.NeighbourIterator;
import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.Spielfeld;

public class NeighbourIteratorTest {
	
	private Spielfeld spielfeld; 

	@Before
	public void setUp() throws Exception {
		// Spalte:       0  1  2  3
		//
		// Zeile 0:      o  o  o  b
		// Zeile 1:     (b)(b) w  b
		// Zeile 2:      o  w  o  w
		// Zeile 3:     (b) o  b (b)
		//
		
		spielfeld = new Spielfeld(4); // 4x4-Spielfeld
		spielfeld.setForInit(Colors.BLACK,new Pos(0,3));
		spielfeld.setForInit(Colors.WHITE,new Pos(1,2));
		spielfeld.setForInit(Colors.BLACK,new Pos(1,3));
		spielfeld.setForInit(Colors.WHITE,new Pos(2,1));
		spielfeld.setForInit(Colors.WHITE,new Pos(2,3));
		spielfeld.setForInit(Colors.BLACK,new Pos(3,2));
	}

	@Test
	public final void testNeighbourIterator() {
		Set<Pos> resultSet = new HashSet<Pos>();
		NeighbourIterator nit = new NeighbourIterator(spielfeld,new Pos(3,1));
		while (nit.hasNext()){
			resultSet.add(nit.next());
		}
		Assert.assertTrue(resultSet.contains(new Pos(3,0)));
		Assert.assertTrue(resultSet.contains(new Pos(2,0)));
		Assert.assertTrue(resultSet.contains(new Pos(2,1)));
		Assert.assertTrue(resultSet.contains(new Pos(2,2)));
		Assert.assertTrue(resultSet.contains(new Pos(3,2)));

		Assert.assertFalse(resultSet.contains(new Pos(4,0)));
		Assert.assertFalse(resultSet.contains(new Pos(1,0)));
	}

}
