package de.rmrw.ReversiKata.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	SpielfeldTest.class, 
	ColorsTest.class, 
	SpielfeldIteratorTest.class, 
	LineIteratorTest.class, 
	PosTest.class,
	PosComparatorTest.class,
	DirectionIteratorTest.class} )
public final class AllTests {}
