package com.comco.exactcover.puzzle.sudoku;

public class HintAtom extends SudokuAtom {
	private final int row;
	private final int col;
	private final int val;
	
	public HintAtom(Sudoku sudoku, final int row, final int col, final int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;
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
