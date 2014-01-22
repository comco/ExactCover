package com.comco.exactcover.puzzles.sudoku;

import java.util.Stack;

import com.comco.exactcover.Row;
import com.comco.exactcover.Solution;

public class SudokuSolution implements Solution {
	private final Sudoku sudoku;
	private final int[][] board = new int[9][9];
	private final Stack<Row> rows = new Stack<>();
	
	public SudokuSolution(final Sudoku sudoku) {
		this.sudoku = sudoku;
	}
	
	@Override
	public void includeRow(final Row row) {
		SudokuAtom atom = sudoku.getAtom(row.row());
		rows.add(row);
		atom.attachToSolution(this);
	}

	@Override
	public void excludeRow() {
		Row first = rows.pop();
		SudokuAtom atom = sudoku.getAtom(first.row());
		atom.detachFromSolution(this);
	}

	public void setValueAt(int row, int col, int val) {
		board[row][col] = val;
	}

	public void unsetValueAt(int row, int col) {
		board[row][col] = 0;
	}

	@Override
	public void declareConcrete() {
		writeConcreteSolution();
	}
	
	private void writeConcreteSolution() {
		System.out.println("Solution found: ");
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				System.out.format("%d ", board[row][col]);
			}
			System.out.println();
		}
	}
}
