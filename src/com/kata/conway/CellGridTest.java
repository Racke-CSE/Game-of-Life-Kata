package com.kata.conway;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Karl R.
 */
public class CellGridTest {
	
	
	@Test
	public void processCell_noNeighbors_cellStaysDead()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(false);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(false);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(false);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_noNeighbors_cellDies()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(false);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(true);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(false);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(false);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_oneNeighbor_cellDies()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(true);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(false);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(false);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	
	@Test
	public void processCell_oneNeighbor_cellStaysDead()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(false);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(false);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_twoNeighbors_cellLives()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(true);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(false);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertTrue(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_twoNeighbors_cellStaysDead()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(false);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_threeNeighbors_cellLives()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(false);
		tempGrid[0][1] = new SingleCell(true);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(true);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(true);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertTrue(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_threeNeighbors_cellComesToLife()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(false);
		tempGrid[0][1] = new SingleCell(true);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(true);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertTrue(cell.isLivingState());
		
	}
	
	
	@Test
	public void processCell_fourNeighbors_cellDies()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(false);
		tempGrid[0][1] = new SingleCell(true);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(true);
		tempGrid[1][1] = new SingleCell(true);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(true);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	
	@Test
	public void processCell_FourNeighbors_cellStaysDead()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(false);
		tempGrid[0][1] = new SingleCell(true);
		tempGrid[0][2] = new SingleCell(false);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(false);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(true);
		tempGrid[2][2] = new SingleCell(true);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_allNeighbors_cellDies()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(true);
		tempGrid[0][2] = new SingleCell(true);
		tempGrid[1][0] = new SingleCell(true);
		tempGrid[1][1] = new SingleCell(true);
		tempGrid[1][2] = new SingleCell(true);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(true);
		tempGrid[2][2] = new SingleCell(true);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void processCell_AllNeighbors_cellStaysDead()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(true);
		tempGrid[0][2] = new SingleCell(true);
		tempGrid[1][0] = new SingleCell(true);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(true);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(true);
		tempGrid[2][2] = new SingleCell(true);
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		SingleCell cell = cellGrid.processCell(cellGrid.getGrid()[1][1], 1, 1);
		
		assertFalse(cell.isLivingState());
		
	}
	
	@Test
	public void CellGridUtil_saveAndLoad()
	{
		SingleCell[][] tempGrid = new SingleCell[3][3];
		tempGrid[0][0] = new SingleCell(true);
		tempGrid[0][1] = new SingleCell(false);
		tempGrid[0][2] = new SingleCell(true);
		tempGrid[1][0] = new SingleCell(false);
		tempGrid[1][1] = new SingleCell(false);
		tempGrid[1][2] = new SingleCell(true);
		tempGrid[2][0] = new SingleCell(true);
		tempGrid[2][1] = new SingleCell(false);
		tempGrid[2][2] = new SingleCell(true);
		
		
		CellGrid cellGrid = new CellGrid(tempGrid);
		CellGridUtil.saveGrid(cellGrid);
		
		cellGrid = CellGridUtil.loadGridFromFile();
		
		assertTrue(tempGrid.length == 3);
		assertTrue(tempGrid[0].length == 3);
		
		assertTrue(tempGrid[0][0].isLivingState());
		assertFalse(tempGrid[0][1].isLivingState());
		assertTrue(tempGrid[0][2].isLivingState());
		assertFalse(tempGrid[1][0].isLivingState());
		assertFalse(tempGrid[1][1].isLivingState());
		assertTrue(tempGrid[1][2].isLivingState());
		assertTrue(tempGrid[2][0].isLivingState());
		assertFalse(tempGrid[2][1].isLivingState());
		assertTrue(tempGrid[2][2].isLivingState());
		
	}

}
