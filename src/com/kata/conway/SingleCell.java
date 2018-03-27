package com.kata.conway;

/**
 * 
 * This class represents a single cell in a grid of cells, and has two states: living, or dead.
 * 		True corresponds to living.
 * 		False corresponds to dead.
 * 
 * @author Karl R.
 */
public class SingleCell {
	private boolean livingState;
	
	SingleCell ()
	{
		this(false);
	}
	SingleCell(boolean isLiving)
	{
		livingState = isLiving;
	}

	public boolean isLivingState() {
		return livingState;
	}

	public void setLivingState(boolean livingState) {
		this.livingState = livingState;
	}
	
	@Override
	public String toString() {
		return livingState ? "O" : ".";
	}

}
