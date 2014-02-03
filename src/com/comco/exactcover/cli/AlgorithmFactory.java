package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.BasicDancingLinks;
import com.comco.exactcover.algorithm.DegreeDancingLinks;
import com.comco.exactcover.algorithm.MinColumnDancingLinks;
import com.comco.exactcover.puzzle.Puzzle;

public class AlgorithmFactory {

	private AlgorithmFactory() {
	}

	public BasicDancingLinks get(final AlgorithmType type, final Puzzle puzzle) {
		switch (type) {
		case BASIC:
			return new BasicDancingLinks(puzzle.toNetwork());
		case MIN_COLUMN:
			return new MinColumnDancingLinks(puzzle.toNetwork());
		case DEGREE:
			return new DegreeDancingLinks(puzzle.toNetwork());
		default:
			throw new IllegalArgumentException("Algorithm type: " + type
					+ " is unsupported.");
		}
	}

	public static final AlgorithmFactory INSTANCE = new AlgorithmFactory();
}
