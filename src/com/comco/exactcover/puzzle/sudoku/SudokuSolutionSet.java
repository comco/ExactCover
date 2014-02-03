package com.comco.exactcover.puzzle.sudoku;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.SolutionSet;

public class SudokuSolutionSet implements SolutionSet {
	private final ArrayDeque<SudokuConstraint> stack = new ArrayDeque<>();
	private int numberOfSolutionsFound = 0;

	@Override
	public void addRow(Row row) {
		// cast is safe
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
		printSolution(extractBoard());
		++numberOfSolutionsFound;
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

	@Override
	public boolean shouldContinue() {
		return true;
	}

	@Override
	public int getNumberOfSolutionsFound() {
		return numberOfSolutionsFound;
	}
}
