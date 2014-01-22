package com.comco.exactcover.readers;

import java.io.InputStream;

import com.comco.exactcover.puzzles.Puzzle;
import com.comco.exactcover.puzzles.PuzzleType;

/**
 * Reads a puzzle from an input stream.
 * @author comco
 *
 */
public abstract class PuzzleReader {
	public abstract Puzzle read(final InputStream input);

	private static final PuzzleReader SUDOKU_READER = new SudokuReader();
	private static final PuzzleReader POLYMINO_READER = new PolyminoReader();
	
	public static PuzzleReader getReader(final PuzzleType type) {
		switch (type) {
		case SUDOKU:
			return SUDOKU_READER;
		case POLYMINO:
			return POLYMINO_READER;
		default:
			throw new IllegalArgumentException("PuzzleType " + type
					+ " is not supported for creation of puzzle readers.");
		}
	}
}
