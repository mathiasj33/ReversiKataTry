package de.rmrw.ReversiKata.code;

import java.util.EnumSet;

public enum Colors {
	BLACK,
	WHITE,
	VOID;
	
	public static final EnumSet<Colors> PLAYERCOLORS = EnumSet.range(BLACK, WHITE);

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
