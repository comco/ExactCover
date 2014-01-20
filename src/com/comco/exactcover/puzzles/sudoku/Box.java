package com.comco.exactcover.puzzles.sudoku;

public class Box extends Constraint {
	final int row;
	final int col;
	final int val;
	
	public Box(Sudoku sudoku, int row, int col, int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;
	
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				addElement(row + i, col + j, val);
			}
		}
	}
}
