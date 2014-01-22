package com.comco.exactcover.puzzles;

import java.io.InputStream;

/**
 * Reads a puzzle from an input stream.
 * @author comco
 *
 */
public interface PuzzleReader {
	Puzzle read(final InputStream input);
}
