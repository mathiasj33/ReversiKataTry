package de.rmrw.ReversiKata.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpielfeldTest {
	
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
	public final void testToString() {
		String s = spielfeld.toString();
		Assert.assertEquals("o o o b"+System.getProperty("line.separator")+
							"o o w b"+System.getProperty("line.separator")+
							"o w o b"+System.getProperty("line.separator")+
							"o o b o"+System.getProperty("line.separator"),
							s);
	}

}
