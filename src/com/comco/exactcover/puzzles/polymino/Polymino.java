package com.comco.exactcover.puzzles.polymino;

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
	final PositionAtom[][] atomsOnBoard;

	final List<PositionAtom> atoms = new ArrayList<>();
	final List<PieceConstraint> constraints = new ArrayList<>();

	public Polymino(boolean[][] board) {
		this.board = board;
		this.atomsOnBoard = new PositionAtom[rows()][cols()];

		// construct atoms
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

		addPieceRotations(piece, piece.mask);
		if (piece.canFlip) {
			addPieceRotations(piece, maskFlip(piece.mask));
		}
	}

	private void addPieceRotations(final Piece piece, final boolean[][] mask) {
		if (piece.canRotate) {
			boolean[][] current = mask;
			for (int r = 0; r < 4; ++r) {
				addPieceSet(piece, current);
				current = maskRotate(current);
			}
		} else {
			addPieceSet(piece, mask);
		}
	}

	private void addPieceSet(final Piece piece, boolean[][] mask) {
		for (int row = 0; row < rows(); ++row) {
			for (int col = 0; col < cols(); ++col) {
				if (canPlaceAt(board, row, col, mask)) {
					createPeaceSet(piece, row, col, mask);
				}
			}
		}
	}
	
	private PieceConstraint createPeaceSet(Piece piece, int row, int col,
			boolean[][] mask) {
		PieceConstraint result = new PieceConstraint(this, piece, row, col, mask);
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
