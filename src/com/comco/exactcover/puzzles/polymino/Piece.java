package com.comco.exactcover.puzzles.polymino;

import static com.comco.exactcover.utils.MaskUtils.*;

/**
 * Piece of a polymino puzzle.
 * 
 * @author comco
 * 
 */
public class Piece {
	final boolean[][] mask;
	final boolean canRotate;
	final boolean canFlip;

	public Piece(boolean[][] mask, boolean canRotate, boolean canFlip) {
		super();
		this.mask = maskClip(mask);
		this.canRotate = canRotate;
		this.canFlip = canFlip;
	}

	public int rows() {
		return maskRows(mask);
	}

	public int cols() {
		return maskCols(mask);
	}
}
