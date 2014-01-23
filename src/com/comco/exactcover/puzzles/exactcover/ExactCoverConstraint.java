package com.comco.exactcover.puzzles.exactcover;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzleConstraint;

public class ExactCoverConstraint extends PuzzleConstraint {
	public final ExactCover exactCover;
	public final int row;
	private final List<ExactCoverAtom> atoms = new ArrayList<>();
	
	public ExactCoverConstraint(final ExactCover exactCover, final int row) {
		super(exactCover);
		this.exactCover = exactCover;
		this.row = row;

		for (int col = 0; col < exactCover.cols(); ++col) {
			if (exactCover.matrix[row][col]) {
				atoms.add(exactCover.atomAt(col));
			}
		}
	}

	@Override
	public List<ExactCoverAtom> atoms() {
		return atoms;
	}
}
