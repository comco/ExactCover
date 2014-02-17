package com.comco.exactcover.puzzle.exactcover;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzlePart;

public class ExactCoverPart extends PuzzlePart {
	private final ExactCover puzzle;
	private final int row;
	private final List<ExactCoverAtom> atoms = new ArrayList<>();

	public ExactCoverPart(final ExactCover puzzle, final int row) {
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
	public List<ExactCoverAtom> atoms() {
		return atoms;
	}

	public int getRow() {
		return row;
	}

	public ExactCover puzzle() {
		return puzzle;
	}
}
