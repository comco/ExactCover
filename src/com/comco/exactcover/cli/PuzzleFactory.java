package com.comco.exactcover.cli;

import com.comco.exactcover.puzzles.PuzzleReader;
import com.comco.exactcover.puzzles.PuzzleType;
import com.comco.exactcover.puzzles.exactcover.ExactCoverReader;
import com.comco.exactcover.puzzles.polymino.PolyminoReader;
import com.comco.exactcover.puzzles.sudoku.SudokuReader;

public final class PuzzleFactory {
	private static final SudokuReader SUDOKU_READER = new SudokuReader();
	private static final PolyminoReader POLYMINO_READER = new PolyminoReader();
	private static final ExactCoverReader EXACT_COVER_READER = new ExactCoverReader();
	
	public static PuzzleReader getReader(final PuzzleType type) {
		switch (type) {
		case SUDOKU:
			return SUDOKU_READER;
		case POLYMINO:
			return POLYMINO_READER;
		case EXACT_COVER:
			return EXACT_COVER_READER;
		default:
			throw new IllegalArgumentException("The puzzle type " + type
					+ " is unsupported for reading.");
		}
	}
}
