package com.comco.exactcover.puzzle.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;

public class Sudoku extends Puzzle {
	private final SudokuConstraint[][][] boardConstraints = new SudokuConstraint[9][9][10];
	private final List<SudokuConstraint> constraints = new ArrayList<>();
	private final List<SudokuAtom> atoms = new ArrayList<SudokuAtom>();
	private final RowAtom[][] rowAtoms = new RowAtom[9][10];
	private final ColAtom[][] colAtoms = new ColAtom[9][10];
	private final PositionAtom[][] positionAtoms = new PositionAtom[9][9];
	private final BoxAtom[][][] boxAtoms = new BoxAtom[9][9][10];
	
	public Sudoku() {
		// build constraints
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				for (int val = 1; val <= 9; ++val) {
					boardConstraints[row][col][val] = createSudokuConstraint(
							row, col, val);
				}
			}
		}
		
		// build row atoms
		for (int row = 0; row < 9; ++row) {
			for (int val = 1; val <= 9; ++val) {
				rowAtoms[row][val] = createRowAtom(row, val);
			}
		}
		
		// build col atoms
		for (int col = 0; col < 9; ++col) {
			for (int val = 1; val <= 9; ++val) {
				colAtoms[col][val] = createColAtom(col, val);
			}
		}
		
		// build position atoms
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				positionAtoms[row][col] = createPositionAtom(row, col);
			}
		}
		
		// build box atoms
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				for (int val = 1; val <= 9; ++val) {
					boxAtoms[row][col][val] = createBoxAtom(row, col, val);
				}
			}
		}
	}
	
	public void addHint(int row, int col, int val) {
		// add a unique atom to the constraint for this val
		SudokuAtom hintAtom = createHintAtom(row, col, val);
		boardConstraints[row][col][val].addAtom(hintAtom);
	}
	
	private SudokuAtom createHintAtom(int row, int col, int val) {
		return new HintAtom(this, row, col, val);
	}
	
	private RowAtom createRowAtom(int row, int val) {
		RowAtom atom = new RowAtom(this, row, val);
		atoms.add(atom);
		return atom;
	}
	
	private ColAtom createColAtom(int col, int val) {
		ColAtom atom = new ColAtom(this, col, val);
		atoms.add(atom);
		return atom;
	}
	
	private PositionAtom createPositionAtom(int row, int col) {
		PositionAtom atom = new PositionAtom(this, row, col);
		atoms.add(atom);
		return atom;
	}
	
	private BoxAtom createBoxAtom(int row, int col, int val) {
		BoxAtom atom = new BoxAtom(this, row, col, val);
		atoms.add(atom);
		return atom;
	}

	private SudokuConstraint createSudokuConstraint(int row, int col, int val) {
		SudokuConstraint constraint = new SudokuConstraint(this, row, col, val);
		constraints.add(constraint);
		return constraint;
	}

	@Override
	protected List<SudokuAtom> atoms() {
		return atoms;
	}

	@Override
	protected List<SudokuConstraint> constraints() {
		return constraints;
	}

	public SudokuConstraint getConstraint(int row, int col, int val) {
		return boardConstraints[row][col][val];
	}
}
