package de.rmrw.ReversiKata.code;

public enum Colors {
	BLACK,
	WHITE;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.equals(Colors.BLACK))
			return new String("b");
		else
			return new String("w");
	}
	
	public Colors getOppositeColor()
	{
		if (this.equals(Colors.BLACK))
			return Colors.WHITE;
		return Colors.BLACK;
	}
	
}
