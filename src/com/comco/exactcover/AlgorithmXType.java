package com.comco.exactcover;

public enum AlgorithmXType {
	BASIC_ALGORITHM_X("basic");
	;
	public final String name;
	
	private AlgorithmXType(final String name) {
		this.name = name;
	}
	
	public static AlgorithmXType getType(String name) {
		for (AlgorithmXType type : values()) {
			if (type.name.equals(name)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unsupported type name: " + name);
	}
}
