package com.comco.exactcover.puzzle.queens;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;

public class Queens extends Puzzle {
	private final int size;
	private final PlacementConstraint[][] placementConstraints;
	private final RowAtom[] rowAtoms;
	private final ColAtom[] colAtoms;
	private final DiagonalAtom[] diagonalAtoms;
	private final AntidiagonalAtom[] antidiagonalAtoms;
	private final List<BlankDiagonalConstraint> blankDiagonalConstraints = new ArrayList<>();

	public Queens(final int size) {
		if (size > 0) {
			this.size = size;
			placementConstraints = new PlacementConstraint[size][size];

			// build placement constraints
			for (int row = 0; row < size; ++row) {
				for (int col = 0; col < size; ++col) {
					placementConstraints[row][col] = new PlacementConstraint(
							this, row, col);
				}
			}

			// build row atoms
			rowAtoms = new RowAtom[size];
			for (int row = 0; row < size; ++row) {
				rowAtoms[row] = new RowAtom(this, row);
			}

			// build col atoms
			colAtoms = new ColAtom[size];
			for (int col = 0; col < size; ++col) {
				colAtoms[col] = new ColAtom(this, col);
			}

			// build diagonal atoms
			diagonalAtoms = new DiagonalAtom[2 * size - 1];
			for (int sum = 0; sum < 2 * size - 1; ++sum) {
				DiagonalAtom atom = new DiagonalAtom(this, sum);
				diagonalAtoms[sum] = atom;
				blankDiagonalConstraints.add(new BlankDiagonalConstraint(this,
						atom));
			}

			// build antidiagonal atoms
			antidiagonalAtoms = new AntidiagonalAtom[2 * size - 1];
			for (int diff = 1 - size; diff < size; ++diff) {
				AntidiagonalAtom atom = new AntidiagonalAtom(this, diff);
				antidiagonalAtoms[diff + size - 1] = atom;
				blankDiagonalConstraints.add(new BlankDiagonalConstraint(this,
						atom));
			}

			// printBooleanMatrix();
		} else {
			throw new IllegalArgumentException(
					"Queens puzzle must have a positive size.");
		}
	}

	public int getSize() {
		return size;
	}

	PlacementConstraint getPlacementConstraint(int row, int col) {
		return placementConstraints[row][col];
	}
}
