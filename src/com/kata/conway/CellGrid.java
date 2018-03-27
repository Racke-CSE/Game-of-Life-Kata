package com.kata.conway;

/**
 * This class represents the grid where Conway's Game of Life takes place. In it, methods
 * 	to manipulate and process the grid reside.
 * 
 * @author Karl R.
 *
 */
public class CellGrid {
	private SingleCell[][] grid;
	private int xMax = 8;
	private int yMax = 6;
	
	/**
	 * New CellGrids which lack a parameter can default to a standard 8x6
	 */
	public CellGrid()
	{
		//Initialize default grid size
		setGrid(generateRandomGrid(xMax, yMax));
	}
	
	public CellGrid(int xSize, int ySize)
	{

		yMax = ySize;
		xMax = xSize;
		//Initialize default grid of specified size
		setGrid(generateRandomGrid(xSize, ySize));
	}
	
	/**
	 * New CellGrids with an array of SingleCell arrays are set as the primary grid.
	 * @param newGrid
	 */
	public CellGrid(SingleCell[][] newGrid)
	{
		// Set grid to the new grid
		yMax = newGrid.length;
		xMax = newGrid[0].length;
		setGrid(newGrid);
	}
	
	/**
	 * Generates a random grid of size xMaxSize by yMaxSize
	 * @param xMaxSize corresponds to the number of columns
	 * @param yMaxSize corresponds to the number of rows
	 * @return An array of SingleCell array objects, representing a grid.
	 */
	private SingleCell[][] generateRandomGrid(int xMaxSize, int yMaxSize) {
		
		SingleCell [][] defaultGrid = new SingleCell[yMaxSize][xMaxSize];
		for (int yGridPos = 0; yGridPos < yMaxSize; yGridPos++)
		{
			for (int xGridPos = 0; xGridPos < xMaxSize; xGridPos++)
			{
				// For each cell in the grid, toss a coin to see if the cell is alive or dead at the start.
				defaultGrid[yGridPos][xGridPos] = new SingleCell(Math.random() > .5);
			}
		}
		
		return defaultGrid;
	}

	/**
	 * Processes the next state in the Game of Life for the entire grid.
	 */
	public void generateNextState()
	{
		//Create a grid to reflect the next state
		SingleCell[][] newGrid = new SingleCell[yMax][xMax];
		for (int yGridPos = 0; yGridPos < yMax; yGridPos++)
		{
			for (int xGridPos = 0; xGridPos < xMax; xGridPos++)
			{
				// For each cell on the old grid, process its new state in the new grid.
				newGrid[yGridPos][xGridPos] = processCell(grid[yGridPos][xGridPos], xGridPos, yGridPos);
			}
		}
		
		this.setGrid(newGrid);
	}
	
	/**
	 * Prints to the screen what the current grid looks like.
	 */
	public void printGrid()
	{
		for (int yGridPos = 0; yGridPos < yMax; yGridPos++)
		{
			for (int xGridPos = 0; xGridPos < xMax; xGridPos++)
			{
				// Print each element in the stored grid, with alive as 'O' and dead as '.'
				System.out.print( grid[yGridPos][xGridPos].toString());
			}
			System.out.println();
		}
	}
	
	/**
	 * Determines what the next state of a cell is based on the surrounding cells.
	 * @param originalCell - The single cell being analyzed
	 * @param xPos - The column where the cell resides.
	 * @param yPos - The row where the cell resides.
	 * @return the SingleCell object for the next generation.
	 */
	public SingleCell processCell(SingleCell originalCell, int xPos, int yPos)
	{
		int neighborCount = 0;
		// Analyze all cells surrounding the center cell.
		for (int yGridPos = -1; yGridPos <= 1; yGridPos++)
		{
			for (int xGridPos = -1; xGridPos <= 1; xGridPos++)
			{
				// A cell should not consider itself as a neighbor, so skip.
				if (xGridPos == 0 && yGridPos == 0)
				{
					continue;
				}
				// Determine coordinates for the neighbor cell.
				int tempGridx = xPos + xGridPos;
				int tempGridy = yPos + yGridPos;
				
				// If the neighbor cell is within the grid and it's alive, increase the neighbor count.
				if (tempGridx >= 0 && tempGridx < xMax && tempGridy >= 0 && tempGridy < yMax 
						&& grid[tempGridy][tempGridx].isLivingState())
				{
					neighborCount++;
				}
			}
		}
		
		// Cells with two neighbors should keep their living/dead state the same.
		if (neighborCount == 2)
		{
			return new SingleCell(originalCell.isLivingState());
		} 
		else if (neighborCount == 3)
		{
			// Any cell with 3 neighbors must become alive.
			return new SingleCell(true);
		}
		// All other cells must be dead.
		return new SingleCell();
		
	}

	/**
	 * Fetches the grid object for the CellGrid
	 * @return An array of SingleCell arrays.
	 */
	public SingleCell[][] getGrid() {
		return grid;
	}

	/**
	 * Sets the grid object for the CellGrid
	 * @param grid - An array of SingleCell arrays
	 */
	public void setGrid(SingleCell[][] grid) {
		this.grid = grid;
	}

}
