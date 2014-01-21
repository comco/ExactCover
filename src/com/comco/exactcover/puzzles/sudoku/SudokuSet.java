package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.PuzzleSet;

public abstract class SudokuSet extends PuzzleSet {
	private final Sudoku sudoku;
	private final List<SudokuAtom> elements = new ArrayList<>();

	public SudokuSet(final Sudoku sudoku) {
		super(sudoku);
		this.sudoku = sudoku;
	}

	protected void addElement(final SudokuAtom element) {
		elements.add(element);
	}

	protected void addElement(int row, int col, int val) {
		addElement(sudoku.atom(row, col, val));
	}

	@Override
	public Iterable<SudokuAtom> atoms() {
		return elements;
	}
}
