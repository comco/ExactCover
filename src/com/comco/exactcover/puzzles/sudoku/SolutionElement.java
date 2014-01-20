package com.comco.exactcover.puzzles.sudoku;

public class SolutionElement extends Element {
	final int row;
	final int col;
	final int val;
	
	public SolutionElement(Sudoku sudoku, int row, int col, int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;
	}
}
