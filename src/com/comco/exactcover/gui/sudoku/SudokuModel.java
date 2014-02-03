package com.comco.exactcover.gui.sudoku;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.gui.SolutionSetModel;
import com.comco.exactcover.puzzle.sudoku.SudokuConstraint;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionSet;

public class SudokuModel extends SolutionSetModel {
	private final SudokuSolutionSet solutionSet;
	private final ArrayDeque<SudokuConstraint> constraints = new ArrayDeque<>();
	private SudokuConstraint pop;

	public SudokuModel(final SudokuSolutionSet solutionSet) {
		super(solutionSet);
		this.solutionSet = solutionSet;
	}

	@Override
	public void addRow(final Row row) {
		constraints.add((SudokuConstraint) row);
		super.addRow(row);
		pop = null;
	}

	@Override
	public void popRow() {
		super.popRow();
		pop = constraints.pop();
	}

	public SudokuConstraint getPopped() {
		return pop;
	}

	public int getDigitAt(int row, int col) {
		return solutionSet.extractBoard()[row][col];
	}

	public SudokuConstraint getCurrentConstraint() {
		return constraints.peekLast();
	}
}
