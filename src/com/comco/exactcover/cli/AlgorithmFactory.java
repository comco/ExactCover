package com.comco.exactcover.cli;

import com.comco.exactcover.Problem;
import com.comco.exactcover.dancinglinks.BasicDancingLinks;
import com.comco.exactcover.dancinglinks.ColumnNode;
import com.comco.exactcover.dancinglinks.DegreeDancingLinks;
import com.comco.exactcover.dancinglinks.MinColumnDancingLinks;
import com.comco.exactcover.dancinglinks.NaiveDancingLinks;
import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleConvertor;

public class AlgorithmFactory {

	private AlgorithmFactory() {
	}

	public Problem get(final AlgorithmType type, final Puzzle puzzle) {
		ColumnNode head = PuzzleConvertor.INSTANCE.convertToNetwork(puzzle)
				.head();
		switch (type) {
		case NAIVE:
			return new NaiveDancingLinks(head);
		case BASIC:
			return new BasicDancingLinks(head);
		case MIN_COLUMN:
			return new MinColumnDancingLinks(head);
		case DEGREE:
			return new DegreeDancingLinks(head);
		default:
			throw new IllegalArgumentException("Algorithm type: " + type
					+ " is unsupported.");
		}
	}

	public static final AlgorithmFactory INSTANCE = new AlgorithmFactory();
}
