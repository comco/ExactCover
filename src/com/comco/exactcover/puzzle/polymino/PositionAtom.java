package com.comco.exactcover.puzzle.polymino;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleAtom;

public class PositionAtom extends PuzzleAtom {
	private final Polymino puzzle;
	public final int row;
	public final int col;

	public PositionAtom(final Polymino puzzle, final int row, final int col) {
		super(puzzle);
		this.puzzle = puzzle;
		this.row = row;
		this.col = col;
	}

	@Override
	public Puzzle puzzle() {
		return puzzle;
	}
}
