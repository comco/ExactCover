package com.comco.exactcover.puzzle.queens;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleAtom;

public class QueensAtom extends PuzzleAtom {
	private final Queens puzzle;

	protected QueensAtom(final Queens puzzle) {
		super(puzzle);
		this.puzzle = puzzle;
	}

	@Override
	public Puzzle puzzle() {
		return puzzle;
	}

}
