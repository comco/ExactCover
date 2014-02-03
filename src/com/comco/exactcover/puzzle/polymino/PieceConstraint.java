package com.comco.exactcover.puzzle.polymino;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzleAtom;
import com.comco.exactcover.puzzle.PuzzleConstraint;
import com.comco.exactcover.utils.MaskUtils;

/**
 * A constraint signifying that the following piece should be placed at the
 * specified position.
 * 
 * @author comco
 * 
 */
public class PieceConstraint extends PuzzleConstraint {
	private final Polymino puzzle;
	private final Piece piece;
	private final int boardRow;
	private final int boardCol;
	private final boolean[][] mask;
	private final List<PuzzleAtom> atoms = new ArrayList<>();

	public PieceConstraint(final Polymino puzzle, final Piece piece,
			final PieceAtom pieceAtom, final int boardRow, final int boardCol,
			final boolean[][] mask) {
		super(puzzle);
		this.puzzle = puzzle;
		this.piece = piece;
		this.boardRow = boardRow;
		this.boardCol = boardCol;
		this.mask = mask;

		// add the piece atom
		atoms.add(pieceAtom);

		// add the position atoms
		for (int row = 0; row < pieceRows(); ++row) {
			for (int col = 0; col < pieceCols(); ++col) {
				if (mask[row][col]) {
					int atRow = boardRow + row;
					int atCol = boardCol + col;
					tryAddAtom(atRow, atCol);
				}
			}
		}
	}

	private void tryAddAtom(int row, int col) {
		if (puzzle.hasAtomAt(row, col)) {
			atoms.add(puzzle.getAtomAt(row, col));
		}
	}

	@Override
	public List<PuzzleAtom> atoms() {
		return atoms;
	}

	public int pieceRows() {
		return MaskUtils.maskRows(mask);
	}

	public int pieceCols() {
		return MaskUtils.maskCols(mask);
	}

	public int boardRow() {
		return boardRow;
	}

	public int boardCol() {
		return boardCol;
	}

	public boolean occupied(int row, int col) {
		return mask[row][col];
	}

	@Override
	public Polymino puzzle() {
		return puzzle;
	}

	public Piece getPiece() {
		return piece;
	}

	public boolean[][] getMask() {
		return mask;
	}
}
