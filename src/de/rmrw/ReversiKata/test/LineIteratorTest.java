package de.rmrw.ReversiKata.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.ReversiIterator;
import de.rmrw.ReversiKata.code.Spielfeld;

public class LineIteratorTest {
	
	private Spielfeld sf;
	
	
	@Before
	public void setUp() {
		sf = new Spielfeld(4);
	}
	
	@Test
	public void testLineIterator() {
		Set<Pos> result = new HashSet<Pos>();
		ReversiIterator lI = new ReversiIterator(sf, new Pos(2,0), new Pos(1,0)); //Er läuft nach rechts
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		// Spalte:               0  1  2  3
				//
				// Zeile 0:      o  o  o  o
				// Zeile 1:      o  o  o  o
				// Zeile 2:      o  o  o  o
				// Zeile 3:      o  o  o  o
				//
		Assert.assertTrue(result.contains(new Pos(2,0)));
		Assert.assertTrue(result.contains(new Pos(3,0)));
		Assert.assertFalse(result.contains(new Pos(0,1)));
		result.clear();
		lI = new ReversiIterator(sf, new Pos(3,1), new Pos(-1,0));  //links
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(2,1)));
		Assert.assertTrue(result.contains(new Pos(1,1)));
		Assert.assertTrue(result.contains(new Pos(0,1)));
		Assert.assertFalse(result.contains(new Pos(0,0)));
		result.clear();
		lI = new ReversiIterator(sf, new Pos(0,3), new Pos(0,1));  //oben
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(0,2)));
		Assert.assertTrue(result.contains(new Pos(0,1)));
		Assert.assertTrue(result.contains(new Pos(0,0)));
		Assert.assertFalse(result.contains(new Pos(1,0)));
		result.clear();
		lI = new ReversiIterator(sf, new Pos(0,0), new Pos(0,-1));  //unten
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(0,0)));
		Assert.assertTrue(result.contains(new Pos(0,1)));
		Assert.assertTrue(result.contains(new Pos(0,2)));
		Assert.assertFalse(result.contains(new Pos(1,0)));
		result.clear();
		
		lI = new ReversiIterator(sf, new Pos(1,2), new Pos(1,1));  //oben rechts
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(1,2)));
		Assert.assertTrue(result.contains(new Pos(2,1)));
		Assert.assertTrue(result.contains(new Pos(3,0)));
		Assert.assertFalse(result.contains(new Pos(0,0)));
		result.clear();
		lI = new ReversiIterator(sf, new Pos(3,3), new Pos(-1,1));  //oben links
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(2,2)));
		Assert.assertTrue(result.contains(new Pos(1,1)));
		Assert.assertTrue(result.contains(new Pos(0,0)));
		Assert.assertFalse(result.contains(new Pos(3,0)));
		result.clear();
		lI = new ReversiIterator(sf, new Pos(0,0), new Pos(1,-1));  //unten rechts
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(1,1)));
		Assert.assertTrue(result.contains(new Pos(2,2)));
		Assert.assertTrue(result.contains(new Pos(3,3)));
		Assert.assertFalse(result.contains(new Pos(3,0)));
		result.clear();
		lI = new ReversiIterator(sf, new Pos(3,0), new Pos(-1,-1));  //unten links
		while(lI.hasNext()) {
			result.add(lI.next());
		}
		Assert.assertTrue(result.contains(new Pos(2,1)));
		Assert.assertTrue(result.contains(new Pos(1,2)));
		Assert.assertTrue(result.contains(new Pos(0,3)));
		Assert.assertFalse(result.contains(new Pos(2,0)));
		result.clear();
	}
}
