package com.comco.exactcover.puzzle.sudoku;

import java.util.ArrayDeque;

import com.comco.exactcover.AbstractSolutionKnitter;
import com.comco.exactcover.Row;

public class SudokuSolutionSet extends AbstractSolutionKnitter {
	private final ArrayDeque<SudokuConstraint> stack = new ArrayDeque<>();

	@Override
	public void addRow(Row row) {
		// cast is safe
		super.addRow(row);
		addConstraint((SudokuConstraint) row);
	}

	private void addConstraint(SudokuConstraint constraint) {
		stack.addFirst(constraint);
	}

	@Override
	public void popRow() {
		stack.pop();
	}

	public int[][] extractBoard() {
		int[][] board = new int[9][9];
		for (SudokuConstraint constraint : stack) {
			board[constraint.getRow()][constraint.getCol()] = constraint
					.getVal();
		}

		return board;
	}

	@Override
	public void complete() {
		super.complete();
		printSolution(extractBoard());
	}

	private void printSolution(int[][] board) {
		System.out.println("Solution: ");
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				System.out.format("%d ", board[row][col]);
			}
			System.out.println();
		}
	}
}
