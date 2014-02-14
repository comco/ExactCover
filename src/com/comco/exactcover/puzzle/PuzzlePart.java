package com.comco.exactcover.puzzle;

import java.util.List;

import com.comco.exactcover.Row;

public abstract class PuzzlePart implements Row {
	final int id;

	protected PuzzlePart(final Puzzle puzzle) {
		this.id = puzzle.nextPartId();
		puzzle.addPart(this);
	}

	public abstract List<? extends PuzzleAtom> atoms();

	@Override
	public int rowId() {
		return id;
	}
}
