package com.comco.exactcover.puzzles;

public enum PuzzleType {
	SUDOKU("sudoku"),
	POLYMINO("polymino")
	;
	
	private PuzzleType(final String name) {
		this.name = name;
	}
	
	public final String name;
}
