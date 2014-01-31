package com.comco.exactcover.gui;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.puzzle.sudoku.SudokuConstraint;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionSet;

public class SudokuModel extends ObservableSolutionSet {
	private final SudokuSolutionSet solutionSet;
	private final ArrayDeque<SudokuConstraint> constraints = new ArrayDeque<>();
	private SudokuConstraint pop;

	public SudokuModel(final SudokuSolutionSet solutionSet) {
		super(solutionSet);
		this.solutionSet = solutionSet;
	}

	public void sleep() {
		sleep(10);
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRow(final Row row) {
		constraints.add((SudokuConstraint) row);
		super.addRow(row);
		pop = null;
		sleep();
	}

	@Override
	public void popRow() {
		super.popRow();
		pop = constraints.pop();
		sleep();
	}

	public SudokuConstraint getPopped() {
		return pop;
	}

	private boolean solutionFound = false;

	@Override
	public void complete() {
		solutionFound = true;
		super.complete();
		sleep(2000);
	}

	@Override
	public boolean shouldContinue() {
		// return !solutionFound;
		return true;
	}

	public int getDigitAt(int row, int col) {
		return solutionSet.extractBoard()[row][col];
	}

	public SudokuConstraint getCurrentConstraint() {
		return constraints.peekLast();
	}
}
