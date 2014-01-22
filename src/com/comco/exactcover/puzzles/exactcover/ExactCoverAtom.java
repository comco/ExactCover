package com.comco.exactcover.puzzles.exactcover;

import com.comco.exactcover.puzzles.PuzzleAtom;

public class ExactCoverAtom extends PuzzleAtom {
	public final int col;
	
	protected ExactCoverAtom(ExactCover exactCover, int col) {
		super(exactCover);
		this.col = col;
	}
}
