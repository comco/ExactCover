package com.comco.exactcover.puzzle;

import java.util.List;

import com.comco.exactcover.algorithm.Row;

public abstract class PuzzleConstraint implements Row {
	public final int id;
	
	public PuzzleConstraint(final Puzzle puzzle) {
		this.id = puzzle.nextConstraintId();
	}
	
	public abstract List<? extends PuzzleAtom> atoms();
}
