package com.comco.exactcover.puzzle.sudoku;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class SudokuAtom extends PuzzleAtom {
	private final Sudoku sudoku;

	public SudokuAtom(Sudoku sudoku) {
		super(sudoku);
		this.sudoku = sudoku;
	}
	
	protected void attach(int row, int col, int val) {
		sudoku.getConstraint(row, col, val).addAtom(this);
	}
}
