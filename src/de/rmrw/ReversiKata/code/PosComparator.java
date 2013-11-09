package de.rmrw.ReversiKata.code;

import java.util.Comparator;

public class PosComparator implements Comparator<Pos> {
	public int compare(Pos pos1, Pos pos2) {
		if(pos1.getX() < pos2.getX()) {
			return -1;
		}
		else if(pos1.getX() > pos2.getX()) return 1;
		if(pos1.getY() < pos2.getY() && pos1.getX() == pos2.getX()) {
			return -1;
		}
		else if(pos1.getY() > pos2.getY() && pos1.getX() == pos2.getX()) {
			return 1;
		}
		return 0;
	}
}
