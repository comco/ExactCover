package com.comco.exactcover.puzzle.sudoku;

public class RowAtom extends SudokuAtom {
	private final int row;
	private final int val;
	
	public RowAtom(final Sudoku sudoku, final int row, final int val) {
		super(sudoku);
		this.row = row;
		this.val = val;
		
		for (int col = 0; col < 9; ++col) {
			attach(row, col, val);
		}
	}

	public int getRow() {
		return row;
	}

	public int getVal() {
		return val;
	}
}
