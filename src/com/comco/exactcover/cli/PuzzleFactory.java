package com.comco.exactcover.cli;

import com.comco.exactcover.algorithm.SolutionSet;
import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleReader;
import com.comco.exactcover.puzzle.exactcover.ExactCover;
import com.comco.exactcover.puzzle.exactcover.ExactCoverReader;
import com.comco.exactcover.puzzle.exactcover.ExactCoverSolutionSet;
import com.comco.exactcover.puzzle.polymino.PolyminoReader;
import com.comco.exactcover.puzzle.sudoku.SudokuReader;

public final class PuzzleFactory {
	private static final SudokuReader SUDOKU_READER = new SudokuReader();
	private static final PolyminoReader POLYMINO_READER = new PolyminoReader();
	private static final ExactCoverReader EXACT_COVER_READER = new ExactCoverReader();

	protected PuzzleFactory() {
	}

	public PuzzleReader getPuzzleReader(final PuzzleType type) {
		switch (type) {
		case SUDOKU:
			return SUDOKU_READER;
		case POLYMINO:
			return POLYMINO_READER;
		case COVER:
			return EXACT_COVER_READER;
		default:
			throw new IllegalArgumentException("The puzzle type " + type
					+ " is unsupported for reading.");
		}
	}

	public static PuzzleFactory INSTANCE = new PuzzleFactory();

	public SolutionSet getSolutionSet(PuzzleType type, Puzzle puzzle) {
		if (puzzle != null && type.puzzleClass.equals(puzzle.getClass())) {
			switch (type) {
			case COVER:
				return new ExactCoverSolutionSet((ExactCover) puzzle);
			default:
				throw new UnsupportedOperationException("Puzzle type " + type
						+ " is not supported for solution set.");
			}
		} else {
			throw new IllegalArgumentException(
					"Wrong combination of puzzle type and puzzle or puzzle is null.");
		}
	}
}
