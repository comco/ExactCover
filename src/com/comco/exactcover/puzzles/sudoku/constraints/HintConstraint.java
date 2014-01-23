package com.comco.exactcover.puzzles.sudoku.constraints;

import com.comco.exactcover.puzzles.sudoku.Sudoku;
import com.comco.exactcover.puzzles.sudoku.SudokuConstraint;

public class HintConstraint extends SudokuConstraint {
	final int row;
	final int col;
	final int val;

	public HintConstraint(Sudoku sudoku, int row, int col, int val) {
		super(sudoku);
		this.row = row;
		this.col = col;
		this.val = val;

		addElement(row, col, val);
		addElement();
	}
}
