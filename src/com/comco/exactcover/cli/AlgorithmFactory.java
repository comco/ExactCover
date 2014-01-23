package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.Algorithm;
import com.comco.exactcover.algorithm.SmallestColumnAlgorithm;

public class AlgorithmFactory {
	private static final Algorithm BASIC = new Algorithm();
	private static final SmallestColumnAlgorithm SMALL = new SmallestColumnAlgorithm();
	
	protected AlgorithmFactory() {}
	
	public Algorithm get(final AlgorithmType type) {
		switch (type) {
		case BASIC:
			return BASIC;
		case SMALL:
			return SMALL;
		default:
			throw new IllegalArgumentException("Algorithm type: " + type + " is unsupported.");
		}
	}

	public static final AlgorithmFactory INSTANCE = new AlgorithmFactory();
}
