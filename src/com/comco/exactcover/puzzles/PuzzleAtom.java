package com.comco.exactcover.puzzles;

public abstract class PuzzleAtom {
	final Puzzle puzzle;
	public final int id;

	protected PuzzleAtom(final Puzzle puzzle) {
		this.puzzle = puzzle;
		this.id = puzzle.nextAtomId();
	}
}
