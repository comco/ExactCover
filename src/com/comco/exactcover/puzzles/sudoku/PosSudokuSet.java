package com.comco.exactcover.puzzles.sudoku;

public class PosSudokuSet extends SudokuSet {
    final int row;
    final int col;

    public PosSudokuSet(Sudoku sudoku, int row, int col) {
	super(sudoku);
	this.row = row;
	this.col = col;

	for (int val = 1; val <= 9; ++val) {
	    addElement(row, col, val);
	}
    }
}
