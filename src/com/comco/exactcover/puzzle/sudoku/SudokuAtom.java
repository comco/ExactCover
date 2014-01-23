package com.comco.exactcover.puzzle.sudoku;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class SudokuAtom extends PuzzleAtom {
	private final Sudoku puzzle;

	public SudokuAtom(final Sudoku sudoku) {
		super(sudoku);
		this.puzzle = sudoku;
	}

	protected void attach(final int row, final int col, final int val) {
		puzzle.getBoardConstraint(row, col, val).addAtom(this);
	}

	@Override
	public Sudoku puzzle() {
		return puzzle;
	}
}
