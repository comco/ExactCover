package com.comco.exactcover.puzzle.sudoku;

import java.util.Stack;

import com.comco.exactcover.algorithm.Row;
import com.comco.exactcover.algorithm.SolutionSet;

public class SudokuSolutionSet implements SolutionSet {
	private final Stack<SudokuConstraint> stack = new Stack<SudokuConstraint>();
	
	@Override
	public void addRow(Row row) {
		// cast is safe
		addConstraint((SudokuConstraint) row);
	}

	private void addConstraint(SudokuConstraint constraint) {
		stack.add(constraint);
	}
	
	@Override
	public void pop() {
		stack.pop();
	}

	@Override
	public void complete() {
		int[][] board = new int[9][9];
		for (SudokuConstraint constraint : stack) {
			board[constraint.getRow()][constraint.getCol()] = constraint.getVal();
		}
		
		printSolution(board);
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
}
