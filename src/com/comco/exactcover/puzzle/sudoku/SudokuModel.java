package com.comco.exactcover.puzzle.sudoku;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.gui.SolutionKnitterModel;

public class SudokuModel extends SolutionKnitterModel {
	private final SudokuSolutionKnitter solutionSet;
	private final ArrayDeque<SudokuPart> constraints = new ArrayDeque<>();
	private SudokuPart pop;

	public SudokuModel(final SudokuSolutionKnitter solutionSet) {
		super(solutionSet);
		this.solutionSet = solutionSet;
	}

	@Override
	public void addRow(final Row row) {
		constraints.add((SudokuPart) row);
		super.addRow(row);
		pop = null;
	}

	@Override
	public void popRow() {
		super.popRow();
		pop = constraints.pop();
	}

	public SudokuPart getPopped() {
		return pop;
	}

	public int getDigitAt(int row, int col) {
		return solutionSet.extractBoard()[row][col];
	}

	public SudokuPart getCurrentConstraint() {
		return constraints.peekLast();
	}
}
