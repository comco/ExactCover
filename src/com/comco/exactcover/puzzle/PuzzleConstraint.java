package com.comco.exactcover.puzzle;

import com.comco.exactcover.Row;

public abstract class PuzzleConstraint implements Row {
	public final int id;

	public PuzzleConstraint(final Puzzle puzzle) {
		this.id = puzzle.nextConstraintId();
		puzzle.addConstraint(this);
	}

	public abstract Puzzle puzzle();

	public abstract Iterable<? extends PuzzleAtom> atoms();
}
