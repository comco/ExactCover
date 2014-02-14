package com.comco.exactcover.cli;

import com.comco.exactcover.Problem;
import com.comco.exactcover.dancinglinks.BasicDancingLinks;
import com.comco.exactcover.dancinglinks.DegreeDancingLinks;
import com.comco.exactcover.dancinglinks.MinColumnDancingLinks;
import com.comco.exactcover.dancinglinks.NaiveDancingLinks;

public enum AlgorithmType {
	NAIVE("naive", NaiveDancingLinks.class), BASIC("basic",
			BasicDancingLinks.class), MIN_COLUMN("min_column",
			MinColumnDancingLinks.class), DEGREE("degree",
			DegreeDancingLinks.class);

	public final String name;
	public final Class<? extends Problem> algorithmClass;

	private AlgorithmType(final String name,
			final Class<? extends Problem> algorithmClass) {
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
