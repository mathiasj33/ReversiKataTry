package de.rmrw.ReversiKata.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.PosComparator;

public class PosComparatorTest {
	PosComparator pC;
	Pos p1;
	Pos p2;
	
	@Before
	public void setUp() {
		pC = new PosComparator();
	}
	
	@Test
	public void testNegativeX() {
		p1 = new Pos(0,0);
		p2 = new Pos(1,0);
		Assert.assertEquals(-1, pC.compare(p1, p2));
	}
	
	@Test
	public void testPositiveX() {
		p1 = new Pos(2,1);
		p2 = new Pos(1,3);
		Assert.assertEquals(1, pC.compare(p1, p2));
	}

	@Test
	public void testNegativeY() {
		p1 = new Pos(0,0);
		p2 = new Pos(0,1);
		Assert.assertEquals(-1, pC.compare(p1, p2));
	}
	
	@Test
	public void testPositiveY() {
		p1 = new Pos(2,3);
		p2 = new Pos(2,1);
		Assert.assertEquals(1, pC.compare(p1, p2));
	}

	@Test
	public void testEqual() {
		p1 = new Pos(2,1);
		p2 = new Pos(2,1);
		Assert.assertEquals(0, pC.compare(p1, p2));
	}
}
