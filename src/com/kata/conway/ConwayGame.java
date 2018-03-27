package com.kata.conway;

import java.util.Scanner;

/**
 * Main java file for the Conway Game of Life.
 * @author Karl R.
 *
 */
public class ConwayGame {
	
	// Used to house the grid for the Conway game of life.
	public static CellGrid grid;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Loading grid from file. Maximum dimensions accepted are 1000 x 1000.");
		grid = CellGridUtil.loadGridFromFile();
		
		System.out.println("Current grid:");
		grid.printGrid();
		
		while (true)
		{
			System.out.println("What would you like to do?");
			System.out.println("1: Process the next generation.");
			System.out.println("2: Save the current grid.");
			System.out.println("3: Create a random default-sized grid.");
			System.out.println("4: Exit.");
			
			if(scanner.hasNextInt())
			{
				int nextOption = scanner.nextInt();
				switch (nextOption)
				{
				// Process the next generation.
				case 1 :
					grid.generateNextState();
					System.out.println("Grid has finished processing. Here's the next generation:");
					grid.printGrid();
					break;
				// Save the grid to a file.
				case 2 :
					CellGridUtil.saveGrid(grid);
					break;
				// Create a new, random grid
				case 3 :

					System.out.println("How many rows will the grid have? Max size is 1000.");
					int rows = 6;
					int columns = 8;
					if(scanner.hasNextInt())
					{
						rows = scanner.nextInt();
						if (rows > 1000 || rows < 1)
						{
							System.out.println("Invalid number, defaulting to 6.");
							rows = 6;
						}
					}
					else
					{
						System.out.println("Invalid number, defaulting to 6.");
						scanner.nextLine();
					}
					
					System.out.println("How many columns will the grid have? Max size is 1000.");
					
					if(scanner.hasNextInt())
					{
						columns = scanner.nextInt();
						if (columns > 1000 || columns < 1)
						{
							System.out.println("Invalid number, defaulting to 8.");
							columns = 8;
						}
					}
					else
					{
						System.out.println("Invalid number, defaulting to 8.");
						scanner.nextLine();
					}
					
					// Generate a new cell grid of size rows x columns
					grid = new CellGrid(columns, rows);
					grid.printGrid();
					break;
				case 4 :
					System.out.println("Ending program.");
					System.exit(0);
				default :
					System.out.println("Invalid choice selection, please choose again.");
					break;
				}
			}
			else
			{
				System.out.println("Please enter a valid number.");
				scanner.nextLine();
			}
			 
		}

	}


}
