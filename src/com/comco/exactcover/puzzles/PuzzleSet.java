package com.comco.exactcover.puzzles;

public abstract class PuzzleSet {
	final Puzzle puzzle;
	public final int id;

	protected PuzzleSet(final Puzzle puzzle) {
		this.puzzle = puzzle;
		this.id = puzzle.nextSetId();
		puzzle.addSet(this);
	}

	public abstract Iterable<? extends PuzzleAtom> atoms();
}
