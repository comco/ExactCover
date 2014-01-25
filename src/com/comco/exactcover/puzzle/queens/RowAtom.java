package com.comco.exactcover.puzzle.queens;

public class RowAtom extends QueensAtom {
	private final int row;

	public RowAtom(final Queens puzzle, final int row) {
		super(puzzle);
		this.row = row;

		for (int col = 0; col < puzzleSize(); ++col) {
			addPlacementConstraint(row, col);
		}
	}

	public int getRow() {
		return row;
	}
}
