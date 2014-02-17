package com.comco.exactcover.puzzle.exactcover;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class ExactCoverAtom extends PuzzleAtom {
	private final int col;

	protected ExactCoverAtom(final ExactCover puzzle, final int col) {
		super(puzzle);
		this.col = col;
	}

	public int getCol() {
		return col;
	}
}
