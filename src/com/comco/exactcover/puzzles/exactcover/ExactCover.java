package com.comco.exactcover.puzzles.exactcover;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzle.Puzzle;

public class ExactCover extends Puzzle {
	public boolean[][] matrix;
	private final List<ExactCoverAtom> atoms = new ArrayList<ExactCoverAtom>();
	private final List<ExactCoverConstraint> sets = new ArrayList<ExactCoverConstraint>();
	
	public ExactCover(boolean[][] matrix) {
		this.matrix = matrix;
		
		for (int col = 0; col < cols(); ++col) {
			atoms.add(new ExactCoverAtom(this, col));
		}
		
		for (int row = 0; row < rows(); ++row) {
			sets.add(new ExactCoverConstraint(this, row));
		}
	}
	
	@Override
	public List<ExactCoverAtom> atoms() {
		return atoms;
	}

	@Override
	public List<ExactCoverConstraint> constraints() {
		return sets;
	}

	public int rows() {
		return matrix.length;
	}
	
	public int cols() {
		return matrix[0].length;
	}

	public ExactCoverAtom atomAt(int col) {
		return atoms.get(col);
	}
}
