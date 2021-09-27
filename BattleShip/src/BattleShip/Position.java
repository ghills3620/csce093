package BattleShip;

public class Position
{
	public int x = 0;
	public int y = 0;
	
	public Position( int x, int y )
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean equals( Position p )
	{
		return this.x == p.x && this.y == p.y;
		//if( this.x == p.x && this.y == p.y )
		//	return true;
		//return false;
	}

}
