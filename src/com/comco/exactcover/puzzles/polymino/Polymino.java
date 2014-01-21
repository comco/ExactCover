package com.comco.exactcover.puzzles.polymino;

import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;

public class Polymino extends Puzzle {
    final boolean[][] mask;
    final List<Piece> pieces;
    
    public Polymino(boolean[][] mask, List<Piece> pieces) {
	this.mask = mask;
	this.pieces = pieces;
    }

    public void addPiece(final Piece piece) {
	pieces.add(piece);
    }
}
