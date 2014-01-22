package com.comco.exactcover.readers;

import java.io.InputStream;

import com.comco.exactcover.puzzles.Puzzle;

public abstract class PuzzleReader {
	public abstract Puzzle read(final InputStream input);
}
