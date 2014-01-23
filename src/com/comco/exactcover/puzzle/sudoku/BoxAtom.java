package com.comco.exactcover.puzzle.sudoku;

public class BoxAtom extends SudokuAtom {
	private final int row;
	private final int col;
	private final int val;

	public BoxAtom(final Sudoku sudoku, final int row, final int col,
			final int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				attach(row + i, col + j, val);
			}
		}
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getVal() {
		return val;
	}
}
