package de.rmrw.ReversiKata.test;

import org.junit.Assert;
import org.junit.Test;

import de.rmrw.ReversiKata.code.Pos;
import de.rmrw.ReversiKata.code.PosComparator;

public class PosComparatorTest {
	
	@Test
	public void testComparator() {
		PosComparator pC = new PosComparator();
		Pos p1 = new Pos(0,0);
		Pos p2 = new Pos(1,0);
		Assert.assertEquals(-1, pC.compare(p1, p2));
		p1 = new Pos(2,1);
		Assert.assertEquals(-1, pC.compare(p2, p1));
		Assert.assertEquals(1, pC.compare(p1, p2));
		p2 = new Pos(2,1);
		Assert.assertEquals(0, pC.compare(p1, p2));
		Assert.assertEquals(0, pC.compare(p2, p1));
	}

}
