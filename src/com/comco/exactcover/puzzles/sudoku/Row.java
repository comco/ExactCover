package com.comco.exactcover.puzzles.sudoku;

public class Row extends Constraint {
	final int row;
	final int val;
	
	public Row(Sudoku sudoku, int row, int val) {
		super(sudoku);
		this.row = row;
		this.val = val;
		for (int col = 0; col < 9; ++col) {
			addElement(row, col, val);
		}
	}
}
