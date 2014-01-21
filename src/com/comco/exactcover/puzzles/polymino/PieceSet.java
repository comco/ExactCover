package com.comco.exactcover.puzzles.polymino;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.PuzzleSet;
import static com.comco.exactcover.puzzles.polymino.MaskUtils.*;

public class PieceSet extends PuzzleSet {
	final Polymino polymino;
	final Piece piece;
	final int boardRow;
	final int boardCol;
	final boolean[][] mask;
	private final List<PositionAtom> atoms = new ArrayList<>();

	public PieceSet(Polymino polymino, Piece piece, int boardRow, int boardCol,
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
		atoms.add(polymino.atom(row, col));
	}

	@Override
	public Iterable<PositionAtom> atoms() {
		return atoms;
	}
}
