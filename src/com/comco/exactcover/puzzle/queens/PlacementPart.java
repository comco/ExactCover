package com.comco.exactcover.puzzle.queens;

public class PlacementPart extends QueensPart {
	private final int row;
	private final int col;

	public PlacementPart(final Queens puzzle, final int row, final int col) {
		super(puzzle);
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
