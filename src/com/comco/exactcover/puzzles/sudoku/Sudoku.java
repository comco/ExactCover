package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzles.sudoku.constraints.BoxConstraint;
import com.comco.exactcover.puzzles.sudoku.constraints.ColumnConstraint;
import com.comco.exactcover.puzzles.sudoku.constraints.HintConstraint;
import com.comco.exactcover.puzzles.sudoku.constraints.PositionConstraint;
import com.comco.exactcover.puzzles.sudoku.constraints.RowConstraint;

public class Sudoku extends Puzzle {
	private SudokuAtom[][][] matrix = new SudokuAtom[9][9][9];
	private List<SudokuAtom> atoms = new ArrayList<>();
	private List<SudokuConstraint> sets = new ArrayList<>();

	public Sudoku() {
		// initialize elements
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				for (int val = 1; val <= 9; ++val) {
					matrix[row][col][val - 1] = createSudokuAtom(row, col, val);
				}
			}
		}

		// initialize row constraints
		for (int row = 0; row < 9; ++row) {
			for (int val = 1; val <= 9; ++val) {
				createRowSudokuSet(row, val);
			}
		}

		// initialize col constraints
		for (int col = 0; col < 9; ++col) {
			for (int val = 1; val <= 9; ++val) {
				createColSudokuSet(col, val);
			}
		}

		// initialize pos constraints
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				createPosSudokuSet(row, col);
			}
		}

		// initialize box constraints
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				for (int val = 1; val <= 9; ++val) {
					createBoxSudokuSet(row, col, val);
				}
			}
		}
	}

	SudokuAtom createSudokuAtom(int row, int col, int val) {
		SudokuAtom atom = new SudokuAtom(this, row, col, val);
		atoms.add(atom);
		return atom;
	}

	SudokuAtom createSudokuAtom() {
		SudokuAtom element = new SudokuAtom(this);
		atoms.add(element);
		return element;
	}
	
	RowConstraint createRowSudokuSet(int row, int val) {
		RowConstraint set = new RowConstraint(this, row, val);
		sets.add(set);
		return set;
	}
	
	ColumnConstraint createColSudokuSet(int col, int val) {
		ColumnConstraint set = new ColumnConstraint(this, col, val);
		sets.add(set);
		return set;
	}
	
	BoxConstraint createBoxSudokuSet(int row, int col, int val) {
		BoxConstraint set = new BoxConstraint(this, row, col, val);
		sets.add(set);
		return set;
	}
	
	PositionConstraint createPosSudokuSet(int row, int col) {
		PositionConstraint set = new PositionConstraint(this, row, col);
		sets.add(set);
		return set;
	}
	
	public SudokuAtom getAtomAt(int row, int col, int val) {
		return matrix[row][col][val - 1];
	}

	public void addHint(int row, int col, int val) {
		sets.add(new HintConstraint(this, row, col, val));
	}

	@Override
	public List<SudokuAtom> atoms() {
		return atoms;
	}

	@Override
	public List<SudokuConstraint> constraints() {
		return sets;
	}
}
