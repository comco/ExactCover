package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;

public class Sudoku extends Puzzle {
    private PossibleValueAtom[][][] matrix = new PossibleValueAtom[9][9][9];
    private List<SudokuAtom> elements = new ArrayList<>();
    private List<SudokuSet> constraints = new ArrayList<>();
    private int nextElementId = 0;
    private int nextConstraintId = 0;

    void addSolutionElement(int row, int col, int val) {
	PossibleValueAtom element = new PossibleValueAtom(this, row, col, val);
	matrix[row][col][val - 1] = element;
	elements.add(element);
    }

    public Sudoku() {
	// initialize elements
	for (int row = 0; row < 9; ++row) {
	    for (int col = 0; col < 9; ++col) {
		for (int val = 1; val <= 9; ++val) {
		    addSolutionElement(row, col, val);
		}
	    }
	}

	// initialize row constraints
	for (int row = 0; row < 9; ++row) {
	    for (int val = 1; val <= 9; ++val) {
		constraints.add(new RowSudokuSet(this, row, val));
	    }
	}

	// initialize col constraints
	for (int col = 0; col < 9; ++col) {
	    for (int val = 1; val <= 9; ++val) {
		constraints.add(new ColSudokuSet(this, col, val));
	    }
	}

	// initialize pos constraints
	for (int row = 0; row < 9; ++row) {
	    for (int col = 0; col < 9; ++col) {
		constraints.add(new PosSudokuSet(this, row, col));
	    }
	}

	// initialize box constraints
	for (int row = 0; row < 9; row += 3) {
	    for (int col = 0; col < 9; col += 3) {
		for (int val = 1; val <= 9; ++val) {
		    constraints.add(new BoxSudokuSet(this, row, col, val));
		}
	    }
	}
    }

    public PossibleValueAtom element(int row, int col, int val) {
	return matrix[row][col][val - 1];
    }

    public int nextElementId() {
	return nextElementId++;
    }

    public int nextConsraintId() {
	return nextConstraintId++;
    }

    public SudokuAtom newFreshElement() {
	SudokuAtom element = new SudokuAtom(this);
	elements.add(element);
	return element;
    }

    public void addHint(int row, int col, int val) {
	constraints.add(new HintSudokuSet(this, row, col, val));
    }

    public SudokuAtom getElementById(int elementId) {
	return elements.get(elementId);
    }

    public SudokuSet getConstraintById(int constraintId) {
	return constraints.get(constraintId);
    }

    public boolean[][] toExactCover() {
	boolean[][] result = new boolean[elements.size()][constraints.size()];
	for (SudokuSet constraint : constraints) {
	    for (SudokuAtom element : constraint.atoms()) {
		result[element.id][constraint.id] = true;
	    }
	}

	return result;
    }
}
