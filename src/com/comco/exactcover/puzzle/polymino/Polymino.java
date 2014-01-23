package com.comco.exactcover.puzzle.polymino;

import static com.comco.exactcover.utils.MaskUtils.canPlaceAt;
import static com.comco.exactcover.utils.MaskUtils.maskCols;
import static com.comco.exactcover.utils.MaskUtils.maskFlip;
import static com.comco.exactcover.utils.MaskUtils.maskRotate;
import static com.comco.exactcover.utils.MaskUtils.maskRows;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;

public class Polymino extends Puzzle {
	final boolean[][] board;
	final List<Piece> pieces = new ArrayList<>();
	final List<PieceAtom> pieceAtoms = new ArrayList<>();
	final PositionAtom[][] atomsOnBoard;

	final List<PositionAtom> atoms = new ArrayList<>();
	final List<PieceConstraint> constraints = new ArrayList<>();

	public Polymino(boolean[][] board) {
		this.board = board;
		this.atomsOnBoard = new PositionAtom[rows()][cols()];

		// construct position atoms
		for (int row = 0; row < rows(); ++row) {
			for (int col = 0; col < cols(); ++col) {
				if (board[row][col]) {
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

	public void addPiece(final Piece piece) {
		pieces.add(piece);
		final PieceAtom pieceAtom = new PieceAtom(this, piece);
		pieceAtoms.add(pieceAtom);
		
		addPieceRotations(piece, pieceAtom, piece.mask);
		if (piece.canFlip) {
			addPieceRotations(piece, pieceAtom, maskFlip(piece.mask));
		}
	}

	private void addPieceRotations(final Piece piece, final PieceAtom pieceAtom, final boolean[][] mask) {
		if (piece.canRotate) {
			boolean[][] current = mask;
			for (int r = 0; r < 4; ++r) {
				addPieceSet(piece, pieceAtom, current);
				current = maskRotate(current);
			}
		} else {
			addPieceSet(piece, pieceAtom, mask);
		}
	}

	private void addPieceSet(final Piece piece, final PieceAtom pieceAtom, boolean[][] mask) {
		for (int row = 0; row < rows(); ++row) {
			for (int col = 0; col < cols(); ++col) {
				if (canPlaceAt(board, row, col, mask)) {
					createPeaceSet(piece, pieceAtom, row, col, mask);
				}
			}
		}
	}
	
	private PieceConstraint createPeaceSet(Piece piece, PieceAtom pieceAtom, int row, int col,
			boolean[][] mask) {
		PieceConstraint result = new PieceConstraint(this, piece, pieceAtom, row, col, mask);
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
	public List<PositionAtom> atoms() {
		return atoms;
	}

	@Override
	public List<PieceConstraint> constraints() {
		return constraints;
	}
}
