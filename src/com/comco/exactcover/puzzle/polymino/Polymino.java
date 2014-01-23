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
	final boolean[][] board;
	final List<Piece> pieces = new ArrayList<>();
	final List<PuzzleAtom> pieceAtoms = new ArrayList<>();
	final PositionAtom[][] atomsOnBoard;

	final List<PuzzleAtom> atoms = new ArrayList<>();
	final List<PieceConstraint> constraints = new ArrayList<>();

	public Polymino(boolean[][] board) {
		this.board = board;
		this.atomsOnBoard = new PositionAtom[rows()][cols()];

		// construct position atoms
		for (int row = 0; row < rows(); ++row) {
			for (int col = 0; col < cols(); ++col) {
				if (!board[row][col]) {
					atomsOnBoard[row][col] = createPositionAtom(row, col);
				}
			}
		}
	}

	private PositionAtom createPositionAtom(int row, int col) {
		PositionAtom atom = new PositionAtom(this, row, col);
		atoms.add(atom);
		return atom;
	}
	
	private PieceAtom createPieceAtom(final Piece piece) {
		final PieceAtom atom = new PieceAtom(this, piece);
		atoms.add(atom);
		return atom;
	}

	public void addPiece(final Piece piece) {
		pieces.add(piece);
		final PieceAtom pieceAtom = createPieceAtom(piece);
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
			final PieceAtom pieceAtom, boolean[][] mask) {
		for (int row = 0; row < rows(); ++row) {
			for (int col = 0; col < cols(); ++col) {
				if (canPlaceAt(board, row, col, mask)) {
					createPeaceConstraint(piece, pieceAtom, row, col, mask);
				}
			}
		}
	}

	private PieceConstraint createPeaceConstraint(final Piece piece,
			final PieceAtom pieceAtom, final int row, final int col,
			final boolean[][] mask) {
		
		PieceConstraint result = new PieceConstraint(this, piece, pieceAtom,
				row, col, mask);
		constraints.add(result);
		return result;
	}

	public boolean hasAtomAt(int row, int col) {
		return (atomsOnBoard[row][col] != null);
	}

	public PositionAtom getAtomAt(int row, int col) {
		return atomsOnBoard[row][col];
	}

	public int rows() {
		return maskRows(board);
	}

	public int cols() {
		return maskCols(board);
	}

	@Override
	public List<PuzzleAtom> atoms() {
		return atoms;
	}

	@Override
	public List<PieceConstraint> constraints() {
		return constraints;
	}
}
