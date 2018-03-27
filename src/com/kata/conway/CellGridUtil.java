package com.kata.conway;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Karl R.
 *
 */
public class CellGridUtil {
	
	/**
	 * Loads a grid from the file 'savedGrid.grid'. If not found, or an error is found, a random grid is generated.
	 * @return a populated cell grid which defaults to a random grid if a savedGrid.grid file isn't found.
	 */
	public static CellGrid loadGridFromFile()  {
		
		BufferedReader reader = null;
		CellGrid grid = null;
		
		try
		{
			reader = new BufferedReader(new FileReader("savedGrid.grid"));
			String currentLine;
			// Represents each line being loaded by the reader as a string.
			List<String> loadedLines = new ArrayList<String>();
			int gridLength = 0;
			int gridHeight = 0;
			int maxGridHeight = 1000;
			int maxGridLength = 1000;
			
			// If any issues are encountered, we'll default to generating a random, new file.
			boolean defaultToRandom = true;
			while ((currentLine = reader.readLine()) != null) {
				//For the first line, we need to set the expected line length and determine if there are too many elements.
				if (gridHeight == 0)
				{
					gridLength = currentLine.length();
					defaultToRandom = false;
					if (gridLength > maxGridLength)
					{
						System.out.println("Too many cells in a single row. Max size is " + maxGridLength + ".");
						defaultToRandom = true;
						break;
					}
				}
				else if (currentLine.length() != gridLength)
				{
					// All rows must have the same length.
					System.out.println("Rows do not all have the same length. All rows must have the same number of elements.");
					defaultToRandom = true;
					break;
				}
				else if (gridHeight > maxGridHeight)
				{
					// There can't be more rows than the max grid height.
					System.out.println("Can only load a maximum of " + maxGridHeight + " rows.");
					defaultToRandom = true;
					break;
				}
				
				if (!currentLine.matches("^[Oo0.]+$"))
				{
					// The file must only contain the characters 'O', 'o', '0', '.', and new line. Anything else will trip this.
					System.out.println("Warning: The following line contains invalid characters: " + currentLine);
					defaultToRandom = true;
					break;
				}
				
				loadedLines.add(currentLine);
				gridHeight++;
			}
			
			if (defaultToRandom)
			{
				System.out.println("Defaulting to a random grid.");
				grid = new CellGrid();
			}
			else
			{
				// Now that we've loaded and validated the cell data, load it into place.
			    SingleCell[][] newGrid = new SingleCell[gridHeight][gridLength];
				for (int row = 0; row < gridHeight; row++)
				{
					// Treat each loaded line as a character array and convert each element into a SingleCell.
				    char[] gridLine = loadedLines.get(row).toCharArray();
				    for (int column = 0; column < gridLength; column++)
				    {
				    	char cellElement = gridLine[column];
				    	if (cellElement == 'O' || cellElement == '0' || cellElement == 'o')
				    	{
				    		newGrid[row][column] = new SingleCell(true);
				    	}
				    	else
				    	{
				    		newGrid[row][column] = new SingleCell(false);
				    	}
				    }
				}
			
				System.out.println("Grid loaded successfully.");
			
				grid = new CellGrid(newGrid);
			}
			
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("No grid found. Generating random grid...");
			grid = new CellGrid();
		}
		catch (Exception e)
		{
			System.out.println("Other unknown error");
			e.printStackTrace();
			System.exit(0);
		}
		finally
		{
			try
			{
				if (reader != null) 
				{
					reader.close();
				}
			}
			catch (IOException e)
			{
				System.out.println("Reader can't close the file.");
			}
		}
		 return grid;
		
		
	}

	/**
	 * Save the grid in memory to a storage file, which can be fetched and modified.
	 * @param grid A cellgrid object representing the Game of Life.
	 */
	public static void saveGrid(CellGrid grid) {
		
		BufferedWriter bw = null;
		
		try
		{
			bw = new BufferedWriter(new FileWriter("savedGrid.grid"));
			SingleCell[][] currentGrid = grid.getGrid();
			for (int yPos = 0; yPos < currentGrid.length; yPos++)
			{
				for (int xPos = 0; xPos < currentGrid[yPos].length; xPos++)
				{
					// Convert each element into the grid to its 'O' or '.' version.
					bw.append(currentGrid[yPos][xPos].toString());
				}
				bw.newLine();
			}
			
		} 
		catch (IOException e)
		{
			System.out.println("Issue was encountered while attempting to write the file.");
		}
		finally
		{
			try
			{
				bw.flush();
				bw.close();
				System.out.println("Grid successfully saved.");
			}
			catch (IOException e)
			{
				System.out.println("Problem encountered with saving the grid");
			}
		}
		
	}

}
