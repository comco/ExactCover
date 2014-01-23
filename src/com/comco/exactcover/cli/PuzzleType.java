package com.comco.exactcover.cli;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzles.exactcover.ExactCover;
import com.comco.exactcover.puzzles.polymino.Polymino;
import com.comco.exactcover.puzzles.sudoku.Sudoku;

public enum PuzzleType {
	COVER("cover", ExactCover.class),
	POLYMINO("polymino", Polymino.class),
	SUDOKU("sudoku", Sudoku.class);

	public final String name;
	public final Class<? extends Puzzle> puzzleClass;
	
	private PuzzleType(final String name, final Class<? extends Puzzle> puzzleClass) {
		this.name = name;
		this.puzzleClass = puzzleClass;
	}

	public static PuzzleType getType(final String name) {
		for (PuzzleType type : values()) {
			if (type.name.equals(name)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Puzzle " + name
				+ " is unsupported.");
	}
}
