package com.comco.exactcover.puzzle.queens;

import com.comco.exactcover.puzzle.Puzzle;

public class Queens extends Puzzle {
	private final int size;

	public Queens(final int size) {
		if (size > 0) {
			this.size = size;
		} else {
			throw new IllegalArgumentException(
					"Queens puzzle must have a positive size.");
		}
	}

	public int getSize() {
		return size;
	}
}
