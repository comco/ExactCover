package com.comco.exactcover.puzzle.queens;

import java.util.ArrayDeque;

import com.comco.exactcover.AbstractSolutionKnitter;
import com.comco.exactcover.Row;

public class QueensSolutionKnitter extends AbstractSolutionKnitter {
	private final Queens queens;
	private final ArrayDeque<QueensPart> stack = new ArrayDeque<>();

	public QueensSolutionKnitter(final Queens queens) {
		this.queens = queens;
	}

	@Override
	public void addRow(Row row) {
		super.addRow(row);
		addConstraint((QueensPart) row);
	}

	private void addConstraint(QueensPart constraint) {
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

	private void printSolution() {
		int size = queens.getSize();
		boolean[][] board = extractBoard();
		System.out.println("Solution:");
		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				if (board[row][col]) {
					System.out.print('Q');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}

	public boolean[][] extractBoard() {
		int size = queens.getSize();
		boolean[][] board = new boolean[size][size];
		for (QueensPart constraint : stack) {
			if (constraint instanceof PlacementPart) {
				PlacementPart placementConstraint = (PlacementPart) constraint;
				int row = placementConstraint.getRow();
				int col = placementConstraint.getCol();
				board[row][col] = true;
			}
		}
		return board;
	}

	public int getSize() {
		return queens.getSize();
	}
}
