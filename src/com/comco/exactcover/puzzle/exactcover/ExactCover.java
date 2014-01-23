package com.comco.exactcover.puzzle.exactcover;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.utils.MaskUtils;

public class ExactCover extends Puzzle {
	private final boolean[][] matrix;
	private final ExactCoverAtom[] atoms;
	private final ExactCoverConstraint[] constraints;

	public ExactCover(boolean[][] matrix) {
		this.matrix = matrix;
		this.atoms = new ExactCoverAtom[matrixCols()];
		this.constraints = new ExactCoverConstraint[matrixRows()];

		for (int col = 0; col < matrixCols(); ++col) {
			atoms[col] = new ExactCoverAtom(this, col);
		}

		for (int row = 0; row < matrixRows(); ++row) {
			constraints[row] = new ExactCoverConstraint(this, row);
		}
	}

	public int matrixRows() {
		return MaskUtils.maskRows(matrix);
	}

	public int matrixCols() {
		return MaskUtils.maskCols(matrix);
	}

	ExactCoverAtom atomAt(final int col) {
		return atoms[col];
	}

	boolean hasPoint(final int row, final int col) {
		return matrix[row][col];
	}
}
