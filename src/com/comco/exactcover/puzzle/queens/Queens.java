package com.comco.exactcover.puzzle.queens;

import com.comco.exactcover.puzzle.Puzzle;

public class Queens extends Puzzle {
	private final int size;
	private final PlacementConstraint[][] placementConstraints;

	public Queens(final int size) {
		if (size > 0) {
			this.size = size;
			placementConstraints = new PlacementConstraint[size][size];
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
