package com.comco.exactcover.puzzle.sudoku.gui;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.gui.SolutionKnitterModel;
import com.comco.exactcover.puzzle.sudoku.SudokuPart;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionKnitter;

public class SudokuModel extends SolutionKnitterModel {
	private final SudokuSolutionKnitter solutionKnitter;
	private final ArrayDeque<SudokuPart> parts = new ArrayDeque<>();
	private SudokuPart pop;

	public SudokuModel(final SudokuSolutionKnitter solutionSet) {
		super(solutionSet);
		this.solutionKnitter = solutionSet;
	}

	@Override
	public void addRow(final Row row) {
		parts.add((SudokuPart) row);
		super.addRow(row);
		pop = null;
	}

	@Override
	public void popRow() {
		super.popRow();
		pop = parts.pop();
	}

	public SudokuPart getPopped() {
		return pop;
	}

	public int getDigitAt(int row, int col) {
		return solutionKnitter.extractBoard()[row][col];
	}

	public SudokuPart getCurrentConstraint() {
		return parts.peekLast();
	}
}
