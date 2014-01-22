package com.comco.exactcover.cli;

import com.comco.exactcover.AlgorithmXType;
import com.comco.exactcover.dancinglinks.DancingLinksAlgorithmX;

public class AlgorithmFactory {
	private static final DancingLinksAlgorithmX BASIC_ALGORITHM_X = new DancingLinksAlgorithmX();

	public DancingLinksAlgorithmX getAlgorithm(final AlgorithmXType type) {
		switch (type) {
		case BASIC_ALGORITHM_X:
			return BASIC_ALGORITHM_X;
		default:
			throw new IllegalArgumentException("Algorithm " + type
					+ " is unsupported.");
		}
	}
}
