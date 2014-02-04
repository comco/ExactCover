package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.BasicDancingLinks;
import com.comco.exactcover.algorithm.ColumnNode;
import com.comco.exactcover.algorithm.DegreeDancingLinks;
import com.comco.exactcover.algorithm.MinColumnDancingLinks;
import com.comco.exactcover.algorithm.NaiveDancingLinks;
import com.comco.exactcover.puzzle.Puzzle;

public class AlgorithmFactory {

	private AlgorithmFactory() {
	}

	public BasicDancingLinks get(final AlgorithmType type, final Puzzle puzzle) {
		ColumnNode network = puzzle.toNetwork();
		switch (type) {
		case NAIVE:
			return new NaiveDancingLinks(network);
		case BASIC:
			return new BasicDancingLinks(network);
		case MIN_COLUMN:
			return new MinColumnDancingLinks(network);
		case DEGREE:
			return new DegreeDancingLinks(network);
		default:
			throw new IllegalArgumentException("Algorithm type: " + type
					+ " is unsupported.");
		}
	}

	public static final AlgorithmFactory INSTANCE = new AlgorithmFactory();
}
