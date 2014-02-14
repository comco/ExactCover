package com.comco.exactcover.puzzle.polymino;

import java.util.ArrayDeque;

import com.comco.exactcover.AbstractSolutionKnitter;
import com.comco.exactcover.Row;

public class PolyminoSolutionSet extends AbstractSolutionKnitter {
	private final Polymino polymino;
	private final ArrayDeque<PieceConstraint> stack = new ArrayDeque<>();

	public PolyminoSolutionSet(final Polymino polymino) {
		this.polymino = polymino;
	}

	@Override
	public void addRow(Row row) {
		super.addRow(row);
		addConstraint((PieceConstraint) row);
	}

	private void addConstraint(final PieceConstraint constraint) {
		stack.addFirst(constraint);
	}

	@Override
	public void popRow() {
		stack.pop();
	}

	@Override
	public void complete() {
		super.complete();
		printSolution();
	}

	private int[][] board;

	private void buildBoard() {
		int rows = polymino.boardRows();
		int cols = polymino.boardCols();
		if (board == null) {
			board = new int[rows][cols];
		}
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (polymino.getBoard()[row][col]) {
					// wall
					board[row][col] = -2;
				} else {
					// unoccupied
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
	}

	private void printSolution() {
		System.out.println("Solution:");
		buildBoard();
		int rows = polymino.boardRows();
		int cols = polymino.boardCols();

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

	public Polymino getPolymino() {
		return polymino;
	}

	public int getPieceIdAt(int row, int col) {
		buildBoard();
		return board[row][col];
	}
}
