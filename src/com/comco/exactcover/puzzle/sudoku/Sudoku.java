package com.comco.exactcover.puzzle.sudoku;

import com.comco.exactcover.puzzle.Puzzle;

public class Sudoku extends Puzzle {
	private final SudokuPart[][][] boardConstraints = new SudokuPart[9][9][10];
	private final RowAtom[][] rowAtoms = new RowAtom[9][10];
	private final ColAtom[][] colAtoms = new ColAtom[9][10];
	private final PositionAtom[][] positionAtoms = new PositionAtom[9][9];
	private final BoxAtom[][][] boxAtoms = new BoxAtom[9][9][10];

	public Sudoku() {
		// build constraints
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				for (int val = 1; val <= 9; ++val) {
					SudokuPart constraint = new SudokuPart(this,
							row, col, val);
					boardConstraints[row][col][val] = constraint;
				}
			}
		}

		// build row atoms
		for (int row = 0; row < 9; ++row) {
			for (int val = 1; val <= 9; ++val) {
				RowAtom atom = new RowAtom(this, row, val);
				rowAtoms[row][val] = atom;
			}
		}

		// build col atoms
		for (int col = 0; col < 9; ++col) {
			for (int val = 1; val <= 9; ++val) {
				ColAtom atom = new ColAtom(this, col, val);
				colAtoms[col][val] = atom;
			}
		}

		// build position atoms
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				PositionAtom atom = new PositionAtom(this, row, col);
				positionAtoms[row][col] = atom;
			}
		}

		// build box atoms
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				for (int val = 1; val <= 9; ++val) {
					BoxAtom atom = new BoxAtom(this, row, col, val);
					boxAtoms[row][col][val] = atom;
				}
			}
		}
	}

	public void addHint(final int row, final int col, final int val) {
		// add a unique atom to the constraint for this val
		final HintAtom atom = new HintAtom(this, row, col, val);
		boardConstraints[row][col][val].addAtom(atom);
	}

	public SudokuPart getBoardConstraint(final int row, final int col,
			final int val) {
		return boardConstraints[row][col][val];
	}
}
