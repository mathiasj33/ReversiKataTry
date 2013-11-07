package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.Collections;
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
				map.put(new Pos(i,j), Colors.VOID);
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
		SpielfeldIterator sI = new SpielfeldIterator(this);
		while(sI.hasNext()) {
			Pos p = sI.next();
			s += getColor(p);
			if(p.getY() == size - 1) { //Wenn es das letzte Element in der Zeile ist
				s += System.getProperty("line.separator");
			}
			else {
				s += " ";
			}
		}
		return s;
	}

	public boolean esGibtEinenWegVonPosZuFarbe(Pos pos, Colors color) {

		Pos[] dirPos = new Pos[]{
				new Pos(1,0),new Pos(0,1),new Pos(-1,0),new Pos(0,-1),new Pos(1,1),new Pos(-1,-1),new Pos(-1,1),new Pos(1,-1)
		};
		
		for(int i = 0; i < 8; i++) {
			LineIterator lI = new LineIterator(this, pos, dirPos[i]);
			lI.next(); // Start-Position überspringen 

			// erster Nachbar muss existieren und die entgegengesetzte Farbe haben
			if (!lI.hasNext()) continue;
			Pos neighbourPos = lI.next(); 
			if (getColor(neighbourPos)==Colors.VOID || getColor(neighbourPos) == color)
				continue;
			
			// Unsere Startposition hat jetzt also einen Nachbarn in der anderen Farbe.
			// Auf dem weiteren Weg müssen wir jetzt wieder einen in der gleichen Farbe finden:
			while (lI.hasNext()) {
				Pos nextPosInLine = lI.next();
				if (getColor(nextPosInLine)==Colors.VOID)
					break; // Lücke
				if (getColor(nextPosInLine).equals(color))
					return true;
			}
		}
		return false;
	}

	
	public Set<Pos> woKann(Colors color) {
		Set<Pos> result = new HashSet<Pos>();
		for(Pos p : map.keySet()) {
			if(esGibtEinenWegVonPosZuFarbe(p,color) && map.get(p) == Colors.VOID) result.add(p);
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
	
	public ArrayList<Pos> getAllPositionsSorted() {
		ArrayList<Pos> sortedList = new ArrayList<Pos>();
		for(Pos p : map.keySet()) {
			sortedList.add(p);
		}
		Collections.sort(sortedList, new PosComparator());
		return sortedList;
	}

	public Colors getColor(Pos pos) {
		return map.get(pos);
	}

}
