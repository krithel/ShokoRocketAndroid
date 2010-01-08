package uk.danishcake.shokorocket;

public enum SquareType {
	Empty, Rocket, Hole, NorthArrow, SouthArrow, EastArrow, WestArrow, NorthHalfArrow, SouthHalfArrow, WestHalfArrow, EastHalfArrow, NorthDestroyedArrow, SouthDestroyedArrow, WestDestroyedArrow, EastDestroyedArrow;
	
	public Direction ToDirection() {
		switch(this)
		{
		case NorthArrow:
		case NorthHalfArrow:
			return Direction.North;
		case SouthArrow:
		case SouthHalfArrow:
			return Direction.South;
		case EastArrow:
		case EastHalfArrow:
			return Direction.East;
		case WestArrow:
		case WestHalfArrow:
			return Direction.West;
		default:
			return Direction.Invalid;
		}
	}
	
	public Direction GetDirectionality() {
		switch(this)
		{
		case NorthArrow:
		case NorthHalfArrow:
		case NorthDestroyedArrow:
			return Direction.North;
		case SouthArrow:
		case SouthHalfArrow:
		case SouthDestroyedArrow:
			return Direction.South;
		case EastArrow:
		case EastHalfArrow:
		case EastDestroyedArrow:
			return Direction.East;
		case WestArrow:
		case WestHalfArrow:
		case WestDestroyedArrow:
			return Direction.West;
		default:
			return Direction.Invalid;
		}		
	}
	
	public SquareType Diminish()
	{
		switch(this)
		{
		case NorthArrow:
			return SquareType.NorthHalfArrow;
		case SouthArrow:
			return SquareType.SouthHalfArrow;
		case EastArrow:
			return SquareType.EastHalfArrow;
		case WestArrow:
			return SquareType.WestHalfArrow;
		case NorthHalfArrow:
			return SquareType.NorthDestroyedArrow;
		case SouthHalfArrow:
			return SquareType.SouthDestroyedArrow;
		case EastHalfArrow:
			return SquareType.EastDestroyedArrow;
		case WestHalfArrow:
			return SquareType.WestDestroyedArrow;
		default:
			return this;
		}		
	}
	
	public SquareType Restore()
	{
		switch(this)
		{
		case NorthHalfArrow:
			return SquareType.NorthArrow;
		case SouthHalfArrow:
			return SquareType.SouthArrow;
		case EastHalfArrow:
			return SquareType.EastArrow;
		case WestHalfArrow:
			return SquareType.WestArrow;
		case NorthDestroyedArrow:
			return SquareType.NorthArrow;
		case SouthDestroyedArrow:
			return SquareType.SouthArrow;
		case EastDestroyedArrow:
			return SquareType.EastArrow;
		case WestDestroyedArrow:
			return SquareType.WestArrow;
		default:
			return this;
		}		
	}
}
