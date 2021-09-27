package BattleShip;
import java.util.ArrayList;

public class GameBoard
{
	int rowCount = 10;
	int colCount = 10;
	
	final String LINE_END = System.getProperty("line.separator"); 
	
	ArrayList< ArrayList< Cell > > cells;
	ArrayList< Ship > myShips = new ArrayList<>();
	
	public GameBoard( int rowCount, int colCount )
	{
		this.rowCount = rowCount;
		this.colCount = colCount;

		this.cells = new ArrayList< ArrayList< Cell > >();
		for (int i = 0; i <= this.rowCount; i++)
			this.cells.add(new ArrayList<>()); // creates first row

		for (ArrayList<Cell> cell : cells)
			for (int cols = 0; cols < this.colCount; ++cols)
				cell.add(cols, new Cell());
	}
	
	public String draw()
	{
		StringBuilder b = new StringBuilder();
		b.append(LINE_END);

		/* Top boarder */
		for( int i = 0; i <= this.colCount; ++ i)
		{
			if (i == 0 || i == this.colCount)
				b.append('+');
			else
				b.append('-');
		}
		b.append(LINE_END);

		/* side boarder */
		for( int i = 0; i <= this.colCount; ++ i)
		{
			for (int j = 0; j <= this.colCount; j++) {
				if (j == 0 || j == this.rowCount)
					b.append('|');
				else
					b.append(this.cells.get(i).get(j).draw());
			}
			b.append(LINE_END);
		}

			/* bottom boarder */
			for( int i = 0; i <= this.colCount; ++ i)
			{
				if (i == 0 || i == this.colCount)
					b.append('+');
				else
					b.append('-');
		}
		b.append(LINE_END);
		return b.toString();
	}
	
	//add in a ship if it fully 1) fits on the board and 2) doesn't collide w/
	//an existing ship.
	//Returns true on successful addition; false, otherwise
	public boolean addShip( Ship s , Position sternLocation, HEADING bowDirection )
	{
		return false;
	}
	
	//Returns A reference to a ship, if that ship was struck by a missle.
	//The returned ship can then be used to print the name of the ship which
	//was hit to the player who hit it.
	//Ensure you handle missiles that may fly off the grid
	public Ship fireMissle( Position coordinate )
	{
		return null;
	}
	
	//Here's a simple driver that should work without touching any of the code below this point
	public static void main( String [] args )
	{
		System.out.println( "Hello World" );
		GameBoard b = new GameBoard( 10, 10 );	
		System.out.println( b.draw() );
		
		Ship s = new Cruiser( "Cruiser" );
		if( b.addShip(s, new Position(3,6), HEADING.WEST ) )
			System.out.println( "Added " + s.getName() + "Location is " );
		else
			System.out.println( "Failed to add " + s.getName() );
		
		s = new Destroyer( "Vader" );
		if( b.addShip(s, new Position(3,5), HEADING.NORTH ) )
			System.out.println( "Added " + s.getName() + "Location is " );
		else
			System.out.println( "Failed to add " + s.getName() );
		
		System.out.println( b.draw() );
		
		b.fireMissle( new Position(3,5) );
		System.out.println( b.draw() );
		b.fireMissle( new Position(3,4) );
		System.out.println( b.draw() );
		b.fireMissle( new Position(3,3) );
		System.out.println( b.draw() );
		
		b.fireMissle( new Position(0,6) );
		b.fireMissle( new Position(1,6) );
		b.fireMissle( new Position(2,6) );
		b.fireMissle( new Position(3,6) );
		System.out.println( b.draw() );
		
		b.fireMissle( new Position(6,6) );
		System.out.println( b.draw() );
	}

}
