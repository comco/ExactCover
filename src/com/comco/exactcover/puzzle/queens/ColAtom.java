package com.comco.exactcover.puzzle.queens;

public class ColAtom extends QueensAtom {
	private final int col;

	public ColAtom(final Queens puzzle, final int col) {
		super(puzzle);
		this.col = col;

		for (int row = 0; row < puzzleSize(); ++row) {
			addPlacementConstraint(row, col);
		}
	}

	public int getCol() {
		return col;
	}
}
