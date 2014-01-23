package com.comco.exactcover.puzzle.sudoku.constraints;

import com.comco.exactcover.puzzle.sudoku.Sudoku;
import com.comco.exactcover.puzzle.sudoku.SudokuConstraint;

public class ColumnConstraint extends SudokuConstraint {
	final int val;
	final int col;

	public ColumnConstraint(Sudoku sudoku, int col, int val) {
		super(sudoku);
		this.col = col;
		this.val = val;
		for (int row = 0; row < 9; ++row) {
			addElement(row, col, val);
		}
	}
}
