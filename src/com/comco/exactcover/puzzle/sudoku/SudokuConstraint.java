package com.comco.exactcover.puzzle.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzleConstraint;

public abstract class SudokuConstraint extends PuzzleConstraint {
	private final Sudoku sudoku;
	private final List<SudokuAtom> atoms = new ArrayList<>();

	public SudokuConstraint(final Sudoku sudoku) {
		super(sudoku);
		this.sudoku = sudoku;
	}

	protected void addElement(final SudokuAtom atom) {
		atoms.add(atom);
	}

	protected void addElement(int row, int col, int val) {
		addElement(sudoku.getAtomAt(row, col, val));
	}
	
	protected void addElement() {
		addElement(sudoku.createSudokuAtom());
	}

	@Override
	public List<SudokuAtom> atoms() {
		return atoms;
	}
}
