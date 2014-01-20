package com.comco.exactcover.puzzles.sudoku;

public class Col extends Constraint {
	final int val;
	final int col;
	
	public Col(Sudoku sudoku, int col, int val) {
		super(sudoku);
		this.col = col;
		this.val = val;
		for (int row = 0; row < 9; ++row) {
			addElement(row, col, val);
		}
	}
}
