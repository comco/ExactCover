package com.comco.exactcover.puzzles.polymino;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;

import static com.comco.exactcover.puzzles.polymino.MaskUtils.*;

public class Polymino extends Puzzle {
    final boolean[][] board;
    final List<Piece> pieces = new ArrayList<>();
    final List<PieceSet> sets = new ArrayList<>();
    final PositionAtom[][] atoms;
    
    public Polymino(boolean[][] board) {
	this.board = board;
	this.atoms = new PositionAtom[rows()][cols()];
	
	// construct atoms
	for (int row = 0; row < rows(); ++row) {
	    for (int col = 0; col < cols(); ++col) {
		if (board[row][col]) {
		    atoms[row][col] = new PositionAtom(this, row, col);
		}
	    }
	}
    }

    public void addPiece(final Piece piece) {
	pieces.add(piece);
	
	addPieceRotations(piece, piece.mask);
	if (piece.canFlip) {
	    addPieceRotations(piece, maskFlip(piece.mask));
	}
    }
    
    public PositionAtom atom(int row, int col) {
	return atoms[row][col];
    }
    
    public int rows() {
	return maskRows(board);
    }
    
    public int cols() {
	return maskCols(board);
    }

    public boolean hasAtomAt(int row, int col) {
	return (atoms[row][col] != null);
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
        	    sets.add(new PieceSet(this, piece, row, col, mask));
        	}
            }
        }
    }
}
