package com.comco.exactcover.puzzles.sudoku;

import com.comco.exactcover.puzzles.PuzzleAtom;

public class SudokuAtom extends PuzzleAtom {
	public SudokuAtom(final Sudoku sudoku) {
		super(sudoku);
	}
	
	public void attachToSolution(final SudokuSolution solution) {
		// Do nothing by default.
	}
	
	public void detachFromSolution(final SudokuSolution solution) {
		// Do nothing by default.
	}
}
