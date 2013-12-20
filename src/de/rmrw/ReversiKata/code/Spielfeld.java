package de.rmrw.ReversiKata.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Spielfeld {
	
	private int size;
	private TreeMap<Pos,Colors> map = new TreeMap<Pos,Colors>();
	
	public Spielfeld(int s) {
		size = s;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map.put(new Pos(i,j), Colors.VOID);
			}
		}
	}
	
	public void setForInit(Colors c, Pos p) {
		if(size <= p.getZeile() || size <= p.getSpalte()) {
			throw new RuntimeException("Position ausserhalb des Spielfelds");
		}
		map.put(p, c);
	}
	
	@Override
	public String toString() {
		String s = "";
		SpielfeldIterator sI = createSpielfeldIterator();
		while(sI.hasNext()) {
			Pos p = sI.next();
			s += getColor(p);
			if(p.getSpalte() == size - 1) { //Wenn es das letzte Element in der Zeile ist
				s += System.getProperty("line.separator");
			}
			else {
				s += " ";
			}
		}
		return s;
	}

	public boolean esGibtEinenWegVonPosZuFarbe(Pos pos, Colors color) {
		if(berechneUndPruefeWeg(pos, color).size() > 0) return true;
		return false;
	}
	
	public ArrayList<Pos> berechneUndPruefeWeg(Pos startPos, Colors c) {
		ArrayList<Pos> mainList = new ArrayList<Pos>();
		DirectionIterator dit = createDirectionIterator(startPos, this);
		
		while(dit.hasNext()) {
			ArrayList<Pos> aL = new ArrayList<Pos>();
			Pos p = dit.next();
			LineIterator lI = createLineIterator(startPos, p);
			lI.next(); // Start-Position überspringen 

			// erster Nachbar muss existieren und die entgegengesetzte Farbe haben
			if (!lI.hasNext()) continue;
			Pos neighbourPos = lI.next(); 
			if (getColor(neighbourPos)==Colors.VOID || getColor(neighbourPos) == c)
				continue;
			aL.add(neighbourPos);
			// Unsere Startposition hat jetzt also einen Nachbarn in der anderen Farbe.
			// Auf dem weiteren Weg müssen wir jetzt wieder einen in der gleichen Farbe finden:
			while (lI.hasNext()) {
				Pos nextPosInLine = lI.next();
				if (getColor(nextPosInLine)==Colors.VOID) {
					break; // Lücke
				}
				else if (getColor(nextPosInLine).equals(c)) {
					for(Pos pos : aL) {
						mainList.add(pos);
					}
					break;
				}
				else {
					aL.add(nextPosInLine);
				}
			}
		}
		return mainList;
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

	public Colors getColor(Pos pos) {
		return map.get(pos);
	}
	
	public SpielfeldIterator createSpielfeldIterator(){
		return new SpielfeldIterator(this);
	}
	
	public LineIterator createLineIterator(Pos p, Pos dirPos) {
		return new LineIterator(this, p, dirPos);
	}

	public DirectionIterator createDirectionIterator(Pos p, Spielfeld s) {
		return new DirectionIterator(p, s);
	}
	
	public TreeMap<Pos, Colors> getTreeMap() {
		return map;
	}
	
	public void setzeSpielstein(Colors color, Pos p) {
		if(woKann(color).contains(p)) {
			setForInit(color, p);
			ArrayList<Pos> positions = berechneUndPruefeWeg(p, color);
			for(Pos pos : positions) {
				map.put(pos, color);
			}
		}
	}
	
	public int anzahl(Colors color) {
		int i = 0;
		for(Colors c : map.values()) {
			if(c == color) i++;
		}
		return i;
	}

}
