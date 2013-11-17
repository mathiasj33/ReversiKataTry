package de.rmrw.ReversiKata.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import de.rmrw.ReversiKata.code.DirectionIterator;
import de.rmrw.ReversiKata.code.Pos;

public class DirectionIteratorTest {

	@Test
	public final void testDirectionIterator() {
		Set<Pos> resultSet = new HashSet<Pos>();
		DirectionIterator dit = new DirectionIterator();
		while(dit.hasNext()) {
			resultSet.add(dit.next());
		}
		Assert.assertTrue(resultSet.contains(new Pos(1,0)));
		Assert.assertTrue(resultSet.contains(new Pos(-1,0)));
		Assert.assertTrue(resultSet.contains(new Pos(0,-1)));
		Assert.assertTrue(resultSet.contains(new Pos(0,1)));
		Assert.assertTrue(resultSet.contains(new Pos(-1,-1)));
		Assert.assertTrue(resultSet.contains(new Pos(1,1)));
		Assert.assertTrue(resultSet.contains(new Pos(1,-1)));
		Assert.assertTrue(resultSet.contains(new Pos(-1,1)));
	}

}
