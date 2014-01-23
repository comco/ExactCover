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
		System.out.println("Solution:");
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
			int pieceRows = constraint.pieceRows();
			int pieceCols = constraint.pieceCols();
			int boardRow = constraint.getBoardRow();
			int boardCol = constraint.getBoardCol();
			int id = constraint.piece.id;
			for (int row = 0; row < pieceRows; ++row) {
				for (int col = 0; col < pieceCols; ++col) {
					if (constraint.occupied(row, col)) {
						board[boardRow + row][boardCol + col] = id;
					}
				}
			}
		}
		
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (board[row][col] >= 0) {
					System.out.format("%d ", board[row][col]);
				}
				System.out.println();
			}
		}
	}
}
