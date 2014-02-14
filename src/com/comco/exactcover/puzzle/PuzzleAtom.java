package com.comco.exactcover.puzzle;

import com.comco.exactcover.Col;

public abstract class PuzzleAtom implements Col {
	final int id;

	protected PuzzleAtom(final Puzzle puzzle) {
		this.id = puzzle.nextAtomId();
		puzzle.addAtom(this);
	}

	@Override
	public int colId() {
		return id;
	}
}
