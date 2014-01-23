package com.comco.exactcover.puzzle.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzleConstraint;

public class SudokuConstraint extends PuzzleConstraint {
	private final Sudoku puzzle;
	private final int row;
	private final int col;
	private final int val;

	private final List<SudokuAtom> atoms = new ArrayList<SudokuAtom>();

	public SudokuConstraint(final Sudoku puzzle, final int row, final int col,
			final int val) {
		super(puzzle);
		this.puzzle = puzzle;
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public Iterable<SudokuAtom> atoms() {
		return atoms;
	}

	void addAtom(final SudokuAtom rowAtom) {
		atoms.add(rowAtom);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getVal() {
		return val;
	}

	@Override
	public Sudoku puzzle() {
		return puzzle;
	}
}
