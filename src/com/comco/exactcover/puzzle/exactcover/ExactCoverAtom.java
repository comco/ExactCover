package com.comco.exactcover.puzzle.exactcover;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class ExactCoverAtom extends PuzzleAtom {
	private final ExactCover puzzle;
	private final int col;

	protected ExactCoverAtom(final ExactCover puzzle, final int col) {
		super(puzzle);
		this.puzzle = puzzle;
		this.col = col;
	}

	@Override
	public ExactCover puzzle() {
		return puzzle;
	}

	public int getCol() {
		return col;
	}
}
