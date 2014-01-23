package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.Algorithm;

public class AlgorithmFactory {
	private static final Algorithm BASIC = new Algorithm();
	
	protected AlgorithmFactory() {}
	
	public Algorithm get(final AlgorithmType type) {
		switch (type) {
		case BASIC:
			return BASIC;
		default:
			throw new IllegalArgumentException("Algorithm type: " + type + " is unsupported.");
		}
	}

	public static final AlgorithmFactory INSTANCE = new AlgorithmFactory();
}
