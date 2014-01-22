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
	
	@Override
	public void attachToSolution(final SudokuSolution solution) {
		solution.setValueAt(row, col, val);
	}
	
	@Override
	public void detachFromSolution(final SudokuSolution solution) {
		solution.unsetValueAt(row, col);
	}
}
