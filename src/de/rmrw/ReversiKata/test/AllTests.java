package de.rmrw.ReversiKata.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.rmrw.ReversiKata.viewsTest.JavaFXSpielTest;
import de.rmrw.ReversiKata.viewsTest.JavaFXSpielfeldFeldTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	SpielfeldTest.class, 
	ColorsTest.class, 
	SpielfeldIteratorTest.class, 
	LineIteratorTest.class, 
	PosTest.class,
	DirectionIteratorTest.class,
	SpielTest.class,
	SpielfeldFeldZustandTest.class,
	JavaFXSpielfeldFeldTest.class,
	JavaFXSpielTest.class} )
public final class AllTests {}
