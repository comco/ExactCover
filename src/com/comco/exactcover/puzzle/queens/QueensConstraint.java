package com.comco.exactcover.puzzle.queens;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleConstraint;

public class QueensConstraint extends PuzzleConstraint {
	private final Queens puzzle;
	private final List<QueensAtom> atoms = new ArrayList<QueensAtom>();

	protected QueensConstraint(final Queens puzzle) {
		super(puzzle);
		this.puzzle = puzzle;
	}

	@Override
	public Puzzle puzzle() {
		return puzzle;
	}

	@Override
	public Iterable<QueensAtom> atoms() {
		return atoms;
	}

	void addAtom(final QueensAtom atom) {
		atoms.add(atom);
	}
}
