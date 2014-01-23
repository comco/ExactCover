package com.comco.exactcover.puzzle.polymino;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleAtom;

public class PolyminoAtom extends PuzzleAtom {
	private final Polymino puzzle;

	public PolyminoAtom(final Polymino puzzle) {
		super(puzzle);
		this.puzzle = puzzle;
	}

	@Override
	public Puzzle puzzle() {
		return puzzle;
	}
}
