package com.comco.exactcover.puzzles.sudoku.constraints;

import com.comco.exactcover.puzzles.sudoku.Sudoku;
import com.comco.exactcover.puzzles.sudoku.SudokuConstraint;

public class PositionConstraint extends SudokuConstraint {
	final int row;
	final int col;

	public PositionConstraint(Sudoku sudoku, int row, int col) {
		super(sudoku);
		this.row = row;
		this.col = col;

		for (int val = 1; val <= 9; ++val) {
			addElement(row, col, val);
		}
	}
}
