package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;
import com.comco.exactcover.puzzles.PuzzleType;

public class Sudoku extends Puzzle {
	private PossibleValueAtom[][][] matrix = new PossibleValueAtom[9][9][9];
	private List<SudokuAtom> atoms = new ArrayList<>();
	private List<SudokuSet> sets = new ArrayList<>();

	public Sudoku() {
		super(PuzzleType.SUDOKU);
		
		// initialize elements
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				for (int val = 1; val <= 9; ++val) {
					matrix[row][col][val - 1] = createPossibleValueAtom(row, col, val);
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

	PossibleValueAtom createPossibleValueAtom(int row, int col, int val) {
		PossibleValueAtom atom = new PossibleValueAtom(this, row, col, val);
		atoms.add(atom);
		return atom;
	}

	SudokuAtom createSudokuAtom() {
		SudokuAtom element = new SudokuAtom(this);
		atoms.add(element);
		return element;
	}
	
	RowSudokuSet createRowSudokuSet(int row, int val) {
		RowSudokuSet set = new RowSudokuSet(this, row, val);
		sets.add(set);
		return set;
	}
	
	ColSudokuSet createColSudokuSet(int col, int val) {
		ColSudokuSet set = new ColSudokuSet(this, col, val);
		sets.add(set);
		return set;
	}
	
	BoxSudokuSet createBoxSudokuSet(int row, int col, int val) {
		BoxSudokuSet set = new BoxSudokuSet(this, row, col, val);
		sets.add(set);
		return set;
	}
	
	PosSudokuSet createPosSudokuSet(int row, int col) {
		PosSudokuSet set = new PosSudokuSet(this, row, col);
		sets.add(set);
		return set;
	}
	
	public PossibleValueAtom getAtomAt(int row, int col, int val) {
		return matrix[row][col][val - 1];
	}

	public void addHint(int row, int col, int val) {
		sets.add(new HintSudokuSet(this, row, col, val));
	}

	@Override
	public Iterable<SudokuAtom> atoms() {
		return atoms;
	}

	@Override
	public Iterable<SudokuSet> sets() {
		return sets;
	}

	@Override
	public SudokuAtom getAtom(int id) {
		return atoms.get(id);
	}

	@Override
	public SudokuSet getSet(int id) {
		return sets.get(id);
	}

	@Override
	public SudokuSolution createSolution() {
		return new SudokuSolution(this);
	}
}
