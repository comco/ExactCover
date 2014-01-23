package com.comco.exactcover.puzzles.polymino;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class PositionAtom extends PuzzleAtom {
	public final int row;
	public final int col;

	public PositionAtom(Polymino polymino, int row, int col) {
		super(polymino);
		this.row = row;
		this.col = col;
	}
}
