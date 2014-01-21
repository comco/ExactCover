package com.comco.exactcover.puzzles.sudoku;

public class PossibleValueAtom extends SudokuAtom {
	final int row;
	final int col;
	final int val;

	public PossibleValueAtom(Sudoku sudoku, int row, int col, int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;
	}
}
