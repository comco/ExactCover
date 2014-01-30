package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.BasicDancingLinks;
import com.comco.exactcover.algorithm.MinColumnDancingLinks;

public enum AlgorithmType {
	BASIC("basic", BasicDancingLinks.class), MIN_COLUMN("min_column",
			MinColumnDancingLinks.class);

	public final String name;
	public final Class<? extends BasicDancingLinks> algorithmClass;

	private AlgorithmType(final String name,
			final Class<? extends BasicDancingLinks> algorithmClass) {
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
