package com.comco.exactcover.puzzle.sudoku;

public class PositionAtom extends SudokuAtom {
	private final int row;
	private final int col;

	public PositionAtom(final Sudoku sudoku, final int row, final int col) {
		super(sudoku);
		this.row = row;
		this.col = col;

		for (int val = 1; val <= 9; ++val) {
			attach(row, col, val);
		}
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
