package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.Algorithm;
import com.comco.exactcover.algorithm.SmallestColumnAlgorithm;

public enum AlgorithmType {
	BASIC("basic", Algorithm.class),
	SMALL("small", SmallestColumnAlgorithm.class);

	public final String name;
	public final Class<? extends Algorithm> algorithmClass;
	
	private AlgorithmType(final String name,
			final Class<? extends Algorithm> algorithmClass) {
		this.name = name;
		this.algorithmClass = algorithmClass;
	}

	public static AlgorithmType getType(final String name) {
		for (final AlgorithmType type : values()) {
			if (type.name.equals(name)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Algorithm type name: " + name
				+ " is unsupported.");
	}
}
