package com.comco.exactcover.puzzle.queens;

public class AntidiagonalAtom extends QueensAtom {
	private final int difference;

	public AntidiagonalAtom(final Queens puzzle, final int difference) {
		super(puzzle);
		this.difference = difference;
	}

	public int getDifference() {
		return difference;
	}
}
