package com.comco.exactcover.puzzles.polymino;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;

import static com.comco.exactcover.puzzles.polymino.MaskUtils.*;

public class Polymino extends Puzzle {
    final boolean[][] mask;
    final List<Piece> pieces = new ArrayList<Piece>();
    final PositionAtom[][] atoms;
    
    public Polymino(boolean[][] mask) {
	this.mask = mask;
	this.atoms = new PositionAtom[rows()][cols()];
	
	// construct atoms
	for (int row = 0; row < rows(); ++row) {
	    for (int col = 0; col < cols(); ++col) {
		if (mask[row][col]) {
		    atoms[row][col] = new PositionAtom(this, row, col);
		}
	    }
	}
    }

    public void addPiece(final Piece piece) {
	pieces.add(piece);
    }

    public PositionAtom atom(int row, int col) {
	return atoms[row][col];
    }
    
    public int rows() {
	return maskRows(mask);
    }
    
    public int cols() {
	return maskCols(mask);
    }

    public boolean hasAtomAt(int row, int col) {
	return (atoms[row][col] != null);
    }
}
