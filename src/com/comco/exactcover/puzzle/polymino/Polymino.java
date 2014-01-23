package com.comco.exactcover.puzzle.polymino;

import static com.comco.exactcover.utils.MaskUtils.canPlaceAt;
import static com.comco.exactcover.utils.MaskUtils.maskCols;
import static com.comco.exactcover.utils.MaskUtils.maskFlip;
import static com.comco.exactcover.utils.MaskUtils.maskRotate;
import static com.comco.exactcover.utils.MaskUtils.maskRows;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleAtom;

public class Polymino extends Puzzle {
	private int nextPieceId = 0;

	final boolean[][] board;
	final List<Piece> pieces = new ArrayList<>();
	final List<PuzzleAtom> pieceAtoms = new ArrayList<>();
	final PositionAtom[][] atomsOnBoard;
	final List<PieceConstraint> pieceConstraints = new ArrayList<>();

	public Polymino(final boolean[][] board) {
		this.board = board;
		this.atomsOnBoard = new PositionAtom[boardRows()][boardCols()];

		// construct position atoms
		for (int row = 0; row < boardRows(); ++row) {
			for (int col = 0; col < boardCols(); ++col) {
				if (!board[row][col]) {
					PositionAtom atom = new PositionAtom(this, row, col);
					atomsOnBoard[row][col] = atom;
				}
			}
		}
	}

	public void addPiece(final Piece piece) {
		pieces.add(piece);
		final PieceAtom pieceAtom = new PieceAtom(this, piece);
		pieceAtoms.add(pieceAtom);

		tryAddPieceRotations(piece, pieceAtom, piece.mask);
		if (piece.canFlip) {
			tryAddPieceRotations(piece, pieceAtom, maskFlip(piece.mask));
		}
	}

	private void tryAddPieceRotations(final Piece piece,
			final PieceAtom pieceAtom, final boolean[][] mask) {
		if (piece.canRotate) {
			boolean[][] current = mask;
			for (int r = 0; r < 4; ++r) {
				addPieceConstraint(piece, pieceAtom, current);
				current = maskRotate(current);
			}
		} else {
			addPieceConstraint(piece, pieceAtom, mask);
		}
	}

	private void addPieceConstraint(final Piece piece,
			final PieceAtom pieceAtom, final boolean[][] mask) {
		for (int row = 0; row < boardRows(); ++row) {
			for (int col = 0; col < boardCols(); ++col) {
				if (canPlaceAt(board, row, col, mask)) {
					final PieceConstraint pieceConstraint = new PieceConstraint(
							this, piece, pieceAtom, row, col, mask);
					pieceConstraints.add(pieceConstraint);
				}
			}
		}
	}

	public boolean hasAtomAt(int row, int col) {
		return (atomsOnBoard[row][col] != null);
	}

	public PositionAtom getAtomAt(int row, int col) {
		return atomsOnBoard[row][col];
	}

	public int boardRows() {
		return maskRows(board);
	}

	public int boardCols() {
		return maskCols(board);
	}

	int nextPieceId() {
		return nextPieceId++;
	}
}
