package com.comco.exactcover.puzzle.queens;

public class BlankDiagonalConstraint extends QueensConstraint {
	private final QueensAtom diagonalAtom;

	public BlankDiagonalConstraint(final Queens puzzle,
			final QueensAtom diagonalAtom) {
		super(puzzle);
		this.diagonalAtom = diagonalAtom;
	}

	public QueensAtom getDiagonalAtom() {
		return diagonalAtom;
	}

}
