package com.comco.exactcover.puzzles.sudoku;

public class Hint extends Constraint {
	final int row;
	final int col;
	final int val;

	public Hint(Sudoku sudoku, int row, int col, int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;
		
		addElement(row, col, val);
		addElement(sudoku.newFreshElement());
	}
}
