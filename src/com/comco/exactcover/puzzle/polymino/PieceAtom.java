package com.comco.exactcover.puzzle.polymino;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleAtom;

public class PieceAtom extends PuzzleAtom {
	private final Polymino puzzle;
	private final Piece piece;

	public PieceAtom(final Polymino puzzle, final Piece piece) {
		super(puzzle);
		this.puzzle = puzzle;
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	@Override
	public Puzzle puzzle() {
		return puzzle;
	}
}
