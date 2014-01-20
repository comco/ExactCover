package com.comco.exactcover.puzzles.sudoku;

public class Pos extends Constraint {
	final int row;
	final int col;
	
	public Pos(Sudoku sudoku, int row, int col) {
		super(sudoku);
		this.row = row;
		this.col = col;
		
		for (int val = 1; val <= 9; ++val) {
			addElement(row, col, val);
		}
	}
}
