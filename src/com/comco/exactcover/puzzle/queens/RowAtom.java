package com.comco.exactcover.puzzle.queens;

public class RowAtom extends QueensAtom {
	private final int row;

	public RowAtom(final Queens puzzle, final int row) {
		super(puzzle);
		this.row = row;
	}

	public int getRow() {
		return row;
	}
}
