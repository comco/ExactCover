package com.comco.exactcover.puzzle.polymino;

import static com.comco.exactcover.utils.MaskUtils.*;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.PuzzleConstraint;

public class PieceConstraint extends PuzzleConstraint {
	final Polymino polymino;
	final Piece piece;
	final int boardRow;
	final int boardCol;
	final boolean[][] mask;
	private final List<PositionAtom> atoms = new ArrayList<>();

	public PieceConstraint(Polymino polymino, Piece piece, int boardRow, int boardCol,
			boolean[][] mask) {
		super(polymino);
		this.polymino = polymino;
		this.piece = piece;
		this.boardRow = boardRow;
		this.boardCol = boardCol;
		this.mask = mask;

		int pieceRows = maskRows(mask);
		int pieceCols = maskCols(mask);

		for (int r = 0; r < pieceRows; ++r) {
			for (int c = 0; c < pieceCols; ++c) {
				int atRow = boardRow + r;
				int atCol = boardCol + c;
				if (polymino.hasAtomAt(atRow, atCol)) {
					addAtom(atRow, atCol);
				}
			}
		}
	}

	private void addAtom(int row, int col) {
		atoms.add(polymino.getAtomAt(row, col));
	}

	@Override
	public List<PositionAtom> atoms() {
		return atoms;
	}
}
