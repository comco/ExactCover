package com.comco.exactcover.puzzle.queens;

import java.util.ArrayList;
import java.util.List;

public class BlankDiagonalConstraint extends QueensConstraint {
	private final QueensAtom diagonalAtom;
	private final List<QueensAtom> atoms = new ArrayList<>();

	public BlankDiagonalConstraint(final Queens puzzle,
			final QueensAtom diagonalAtom) {
		super(puzzle);
		this.diagonalAtom = diagonalAtom;
		atoms.add(diagonalAtom);
	}

	public QueensAtom getDiagonalAtom() {
		return diagonalAtom;
	}

	@Override
	public List<QueensAtom> atoms() {
		return atoms;
	}
}
