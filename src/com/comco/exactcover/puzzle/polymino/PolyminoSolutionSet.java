package com.comco.exactcover.puzzle.polymino;

import java.util.Stack;

import com.comco.exactcover.algorithm.Row;
import com.comco.exactcover.algorithm.SolutionSet;

public class PolyminoSolutionSet implements SolutionSet {
	private final Polymino polymino;
	private final Stack<PieceConstraint> stack = new Stack<PieceConstraint>();

	public PolyminoSolutionSet(final Polymino polymino) {
		this.polymino = polymino;
	}

	@Override
	public void addRow(Row row) {
		// cast is safe
		addConstraint((PieceConstraint) row);
	}

	private void addConstraint(final PieceConstraint constraint) {
		stack.add(constraint);
	}

	@Override
	public void pop() {
		stack.pop();
	}

	@Override
	public void complete() {
		printSolution();
	}

	@Override
	public boolean shouldContinue() {
		return true;
	}

	private void printSolution() {
		int rows = polymino.rows();
		int cols = polymino.cols();
		final int[][] board = new int[rows][cols];
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (polymino.board[row][col]) {
					board[row][col] = -1;
				}
			}
		}
		
		for (PieceConstraint constraint : stack) {
			int pieceRows = cons
		}
	}
}
