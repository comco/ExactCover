package com.comco.exactcover.puzzle.queens;

public class DiagonalAtom extends QueensAtom {
	private final int sum;

	public DiagonalAtom(final Queens puzzle, final int sum) {
		super(puzzle);
		this.sum = sum;
		for (int row = 0; row <= sum; ++row) {
			int col = sum - row;
			if (row < puzzleSize() && col < puzzleSize()) {
				addPlacementConstraint(row, col);
			}
		}
	}

	public int getSum() {
		return sum;
	}
}
