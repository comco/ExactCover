package com.comco.exactcover.gui.queens;

import com.comco.exactcover.gui.SolutionSetModel;
import com.comco.exactcover.puzzle.queens.QueensSolutionSet;

public class QueensModel extends SolutionSetModel {
	private final QueensSolutionSet solutionSet;

	public QueensModel(final QueensSolutionSet solutionSet) {
		super(solutionSet);
		this.solutionSet = solutionSet;
	}

	public boolean hasQueenAt(int row, int col) {
		return solutionSet.extractBoard()[row][col];
	}

	public boolean canPutQueenAt(int row, int col) {
		boolean[][] board = solutionSet.extractBoard();
		int size = board.length;
		for (int i = 0; i < size; ++i) {
			if (board[row][i] || board[i][col]) {
				return false;
			}
		}

		for (int i = 0; i < size; ++i) {
			int j = row + col - i;
			if (0 <= j && j < size) {
				if (board[i][j]) {
					return false;
				}
			}
		}

		for (int i = 0; i < size; ++i) {
			int j = i - row + col;
			if (0 <= j && j < size) {
				if (board[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	public int getSize() {
		return solutionSet.getSize();
	}
}