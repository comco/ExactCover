package com.comco.exactcover.puzzle.polymino;

import com.comco.exactcover.puzzle.PuzzleAtom;

public class PieceAtom extends PuzzleAtom {
	private final Piece piece;

	public PieceAtom(final Polymino polymino, final Piece piece) {
		super(polymino);
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
	
}
