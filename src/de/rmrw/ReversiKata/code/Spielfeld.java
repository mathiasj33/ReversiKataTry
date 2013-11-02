package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Spielfeld {
	
	private int size;
	private HashMap<Pos,Colors> map = new HashMap<Pos,Colors>();
	
	public Spielfeld(int s) {
		size = s;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map.put(new Pos(i,j), null);
			}
		}
	}
	
	public void setForInit(Colors c, Pos p) {
		if(size <= p.getX() || size <= p.getY()) {
			throw new RuntimeException("Position ausserhalb des Spielfelds");
		}
		map.put(p, c);
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
					System.out.println("true");
					if(map.get(new Pos(i,j)).equals(Colors.BLACK)) {
						s += "b" + System.getProperty("line.separator");
					}
					else {
						s += "w" + System.getProperty("line.separator");
					}
				}
			}
		}
		return s;
	}

	public boolean esGibtEinenWegVonPosZuFarbe(Pos pos, Colors color) {
		ArrayList<Pos> colorPositions = new ArrayList<Pos>();
		for(Pos p : map.keySet()) {
			if(map.get(p) == color) {
				colorPositions.add(p);
			}
		}
		Set<Pos> lineIteratorList = new HashSet<Pos>();
		Pos[] dirPos = new Pos[]{
				new Pos(1,0),new Pos(0,1),new Pos(-1,0),new Pos(0,-1),new Pos(1,1),new Pos(-1,-1),new Pos(-1,1),new Pos(1,-1)
		};
		for(int i = 0; i < 8; i++) {
			ReversiIterator lI = new ReversiIterator(this, pos, dirPos[i]);
			while(lI.hasNext()) {
				lineIteratorList.add(lI.next()); //Diese Liste hat jetzt alle Pos, die auf Linien von startPos liegen
			}
		}
		for(Pos lP : lineIteratorList) {
			for(Pos cP : colorPositions) {
				if(lP.equals(cP)) {
					return true;
				}
			}
		}
		return false;
	}

	public Set<Pos> woKann(Colors color) {
		Set<Pos> result = new HashSet<Pos>();
		for(Pos p : map.keySet()) {
			if(esGibtEinenWegVonPosZuFarbe(p,color) && map.get(p) == null) result.add(p);
		}
		return result;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Pos p) {
		if(map.containsKey(p)) return true;
		return false;
	}
	
	public HashMap<Pos, Colors> getMap() {
		return map;
	}

}
