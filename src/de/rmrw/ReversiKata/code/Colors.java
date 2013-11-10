package de.rmrw.ReversiKata.code;

public enum Colors {
	BLACK,
	WHITE,
	VOID;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.equals(Colors.BLACK))
			return new String("b");
		else if(this.equals(Colors.WHITE))
			return new String("w");
		else 
			return new String("o");
	}
	
	public Colors getOppositeColor()
	{
		if (this.equals(Colors.BLACK))
			return Colors.WHITE;
		else if(this.equals(Colors.WHITE))
				return Colors.BLACK;
		return null;
	}
	
}
