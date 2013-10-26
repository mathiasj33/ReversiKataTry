package de.rmrw.ReversiKata.code;

import java.util.HashMap;

public class Spielfeld {
	
	private int size;
	private HashMap<Pos,Colors> map = new HashMap<Pos,Colors>();
	
	public Spielfeld(int s) {
		size = s;
	}
	
	public void setForInit(Colors c, Pos p) {
		if(size <= p.getX() || size <= p.getY()) {
			throw new RuntimeException("Position ausserhalb des Spielfelds");
		}
		map.put(p,c);
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(map.get(new Pos(i,j)) == null && j != size - 1) {
					s += "o " ;
				}
				else if(map.get(new Pos(i,j)) == null && j == size - 1) {
					s += "o" + System.getProperty("line.separator");
				}
				else if(map.get(new Pos(i,j)) != null && j != size - 1) {
					if(map.get(new Pos(i,j)).equals(Colors.BLACK)) {
						s += "b ";
					}
					else {
						s += "w ";
					}
				}
				else if(map.get(new Pos(i,j)) != null && j == size - 1) {
					if(map.get(new Pos(i,j)).equals(Colors.BLACK)) {
						s += "b" + System.getProperty("line.separator");
					}
					else {
						s += "w" + System.getProperty("line.separator");
					}
				}
			}
		}
		System.out.println(s);
		return s;
	}

}
