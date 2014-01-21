package com.comco.exactcover.puzzles.polymino;

public class Piece {
    final boolean[][] mask;
    final boolean canRotate;
    final boolean canFlip;
    
    public Piece(boolean[][] mask, boolean canRotate, boolean canFlip) {
	super();
	this.mask = mask;
	this.canRotate = canRotate;
	this.canFlip = canFlip;
    }
}
