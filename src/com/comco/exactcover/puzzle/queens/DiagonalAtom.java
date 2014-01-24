package com.comco.exactcover.puzzle.queens;

public class DiagonalAtom extends QueensAtom {
	private final int sum;

	public DiagonalAtom(final Queens puzzle, final int sum) {
		super(puzzle);
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
}
