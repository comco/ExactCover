package com.comco.exactcover.puzzle.queens;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzlePart;

public class QueensConstraint extends PuzzlePart {
	private final Queens puzzle;
	private final List<QueensAtom> atoms = new ArrayList<QueensAtom>();

	protected QueensConstraint(final Queens puzzle) {
		super(puzzle);
		this.puzzle = puzzle;
	}

	public Puzzle puzzle() {
		return puzzle;
	}

	@Override
	public List<QueensAtom> atoms() {
		return atoms;
	}

	void addAtom(final QueensAtom atom) {
		atoms.add(atom);
	}
}
