package BattleShip;

public class Cell
{
	protected boolean struckByMissle = false;
	protected Ship ship = null;
	
	public Cell()
	{
	draw();
	}
	
	public boolean hasBeenStruckByMissile()
	{
		return(true);
	}
	
	public void hasBeenStruckByMissile( boolean wasStruck )
	{	
	}
	
	public char draw()
	{
		if( this.ship == null )
		{
			if( this.struckByMissle )
				return 'x';
			return ' ';
		}
		//a ship is at this cell
		return ship.drawShipStatusAtCell( this.struckByMissle );			
	}
	
	public Ship getShip() { return this.ship; }
	public void setShip( Ship s ) { this.ship = s; }

	public static void main(String[] args)
	{
	}

}
