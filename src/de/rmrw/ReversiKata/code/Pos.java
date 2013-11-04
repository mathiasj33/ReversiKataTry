package de.rmrw.ReversiKata.code;

public class Pos {
	
	private int x;
	private int y;
	
	public Pos(int x, int y) {
		this.setX(x);
		this.setY(y);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pos other = (Pos) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return new String("X: " + x + " Y: " + y);
	}
	
	public Pos add(Pos pos2) {
		return new Pos(x + pos2.getX(), y - pos2.getY());
	}

}
