package com.comco.exactcover.puzzle;

import com.comco.exactcover.algorithm.Column;

public abstract class PuzzleAtom implements Column {
	public final int id;

	public PuzzleAtom(final Puzzle puzzle) {
		this.id = puzzle.nextAtomId();
		puzzle.addAtom(this);
	}

	public abstract Puzzle puzzle();
}
