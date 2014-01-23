package com.comco.exactcover.puzzle;

import java.io.InputStream;

public interface PuzzleReader {
	Puzzle read(final InputStream in);
}
