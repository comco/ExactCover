package com.comco.exactcover.puzzles.sudoku;

public class RowSudokuSet extends SudokuSet {
    final int row;
    final int val;

    public RowSudokuSet(Sudoku sudoku, int row, int val) {
	super(sudoku);
	this.row = row;
	this.val = val;
	for (int col = 0; col < 9; ++col) {
	    addElement(row, col, val);
	}
    }
}
