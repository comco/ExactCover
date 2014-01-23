package com.comco.exactcover.puzzle.exactcover;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzleConstraint;

public class ExactCoverConstraint extends PuzzleConstraint {
	private final ExactCover puzzle;
	private final int row;
	private final List<ExactCoverAtom> atoms = new ArrayList<>();

	public ExactCoverConstraint(final ExactCover puzzle, final int row) {
		super(puzzle);
		this.puzzle = puzzle;
		this.row = row;

		for (int col = 0; col < puzzle.matrixCols(); ++col) {
			if (puzzle.hasPoint(row, col)) {
				atoms.add(puzzle.atomAt(col));
			}
		}
	}

	@Override
	public Iterable<ExactCoverAtom> atoms() {
		return atoms;
	}

	public int getRow() {
		return row;
	}

	@Override
	public ExactCover puzzle() {
		return puzzle;
	}
}
