package com.comco.exactcover.puzzle.queens;

public class AntidiagonalAtom extends QueensAtom {
	private final int difference;

	public AntidiagonalAtom(final Queens puzzle, final int difference) {
		super(puzzle);
		this.difference = difference;

		for (int row = 0; row < puzzleSize(); ++row) {
			int col = row + difference;
			if (0 <= col && col < puzzleSize()) {
				addPlacementConstraint(row, col);
			}
		}
	}

	public int getDifference() {
		return difference;
	}
}
