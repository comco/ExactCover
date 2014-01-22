package com.comco.exactcover.puzzles;

public enum PuzzleType {
	SUDOKU("sudoku"),
	POLYMINO("polymino"), 
	EXACT_COVER("cover")
	;
	
	private PuzzleType(final String name) {
		this.name = name;
	}
	
	public final String name;
	
	public static PuzzleType getType(String name) {
		for (PuzzleType type : values()) {
			if (type.name.equals(name)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Puzzle name unsupported: " + name);
	}
}
