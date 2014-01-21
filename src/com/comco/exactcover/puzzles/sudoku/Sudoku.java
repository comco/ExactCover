package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;

public class Sudoku extends Puzzle {
    private PossibleValueAtom[][][] matrix = new PossibleValueAtom[9][9][9];
    private List<SudokuAtom> atoms = new ArrayList<>();
    private List<SudokuSet> sets = new ArrayList<>();

    void addSolutionElement(int row, int col, int val) {
	PossibleValueAtom element = new PossibleValueAtom(this, row, col, val);
	matrix[row][col][val - 1] = element;
	atoms.add(element);
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
		sets.add(new RowSudokuSet(this, row, val));
	    }
	}

	// initialize col constraints
	for (int col = 0; col < 9; ++col) {
	    for (int val = 1; val <= 9; ++val) {
		sets.add(new ColSudokuSet(this, col, val));
	    }
	}

	// initialize pos constraints
	for (int row = 0; row < 9; ++row) {
	    for (int col = 0; col < 9; ++col) {
		sets.add(new PosSudokuSet(this, row, col));
	    }
	}

	// initialize box constraints
	for (int row = 0; row < 9; row += 3) {
	    for (int col = 0; col < 9; col += 3) {
		for (int val = 1; val <= 9; ++val) {
		    sets.add(new BoxSudokuSet(this, row, col, val));
		}
	    }
	}
    }

    public PossibleValueAtom atom(int row, int col, int val) {
	return matrix[row][col][val - 1];
    }

    public SudokuAtom newFreshElement() {
	SudokuAtom element = new SudokuAtom(this);
	atoms.add(element);
	return element;
    }

    public void addHint(int row, int col, int val) {
	sets.add(new HintSudokuSet(this, row, col, val));
    }

    public SudokuAtom getElementById(int elementId) {
	return atoms.get(elementId);
    }

    public SudokuSet getConstraintById(int constraintId) {
	return sets.get(constraintId);
    }
}
