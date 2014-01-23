package com.comco.exactcover.puzzle.polymino;

import static com.comco.exactcover.utils.MaskUtils.maskClip;
import static com.comco.exactcover.utils.MaskUtils.maskCols;
import static com.comco.exactcover.utils.MaskUtils.maskRows;

/**
 * Piece of a polymino puzzle.
 * 
 * @author comco
 * 
 */
public class Piece {
	private final Polymino puzzle;
	private final int id;
	final boolean[][] mask;
	final boolean canRotate;
	final boolean canFlip;

	public Piece(final Polymino puzzle, final boolean[][] mask,
			final boolean canRotate, final boolean canFlip) {
		this.puzzle = puzzle;
		this.id = puzzle.nextPieceId();
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

	public Polymino getPuzzle() {
		return puzzle;
	}

	public int getId() {
		return id;
	}
}
