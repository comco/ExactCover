package com.comco.exactcover.puzzle.polymino;

/**
 * An atom signifying that a piece should be used exactly once.
 * 
 * @author comco
 * 
 */
public class PieceAtom extends PolyminoAtom {
	private final Piece piece;

	public PieceAtom(final Polymino puzzle, final Piece piece) {
		super(puzzle);
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
}
