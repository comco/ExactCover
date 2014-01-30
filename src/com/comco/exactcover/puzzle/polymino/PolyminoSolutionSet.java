package com.comco.exactcover.puzzle.polymino;

import java.util.Stack;

import com.comco.exactcover.Row;
import com.comco.exactcover.SolutionSet;

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
	public void popRow() {
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
		int rows = polymino.boardRows();
		int cols = polymino.boardCols();
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
			int boardRow = constraint.boardRow();
			int boardCol = constraint.boardCol();
			int id = constraint.getPiece().getId();
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
					System.out.format("%c ", (char) ('A' + board[row][col]));
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
	}
}
