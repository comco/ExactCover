package com.comco.exactcover.puzzle.queens;

import java.util.ArrayDeque;

import com.comco.exactcover.AbstractSolutionSet;
import com.comco.exactcover.Row;

public class QueensSolutionSet extends AbstractSolutionSet {
	private final Queens queens;
	private final ArrayDeque<QueensConstraint> stack = new ArrayDeque<>();

	public QueensSolutionSet(final Queens queens) {
		this.queens = queens;
	}

	@Override
	public void addRow(Row row) {
		super.addRow(row);
		addConstraint((QueensConstraint) row);
	}

	private void addConstraint(QueensConstraint constraint) {
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
		for (QueensConstraint constraint : stack) {
			if (constraint instanceof PlacementConstraint) {
				PlacementConstraint placementConstraint = (PlacementConstraint) constraint;
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
