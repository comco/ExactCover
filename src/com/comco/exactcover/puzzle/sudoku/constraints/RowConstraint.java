package com.comco.exactcover.puzzle.sudoku.constraints;

import com.comco.exactcover.puzzle.sudoku.Sudoku;
import com.comco.exactcover.puzzle.sudoku.SudokuConstraint;

public class RowConstraint extends SudokuConstraint {
	final int row;
	final int val;

	public RowConstraint(Sudoku sudoku, int row, int val) {
		super(sudoku);
		this.row = row;
		this.val = val;
		for (int col = 0; col < 9; ++col) {
			addElement(row, col, val);
		}
	}
}