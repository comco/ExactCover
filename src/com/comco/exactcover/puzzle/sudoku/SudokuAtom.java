package com.comco.exactcover.puzzle.sudoku;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class SudokuAtom extends PuzzleAtom {
	final int row;
	final int col;
	final int val;

	SudokuAtom(Sudoku sudoku, int row, int col, int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;
	}
	
	public SudokuAtom(Sudoku sudoku) {
		this(sudoku, -1, -1, 0);
	}
	
	public boolean isEmpty() {
		return (row == -1 && col == -1 && val == 0);
	}
}
