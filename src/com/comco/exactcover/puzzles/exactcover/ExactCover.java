package com.comco.exactcover.puzzles.exactcover;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.puzzles.Puzzle;
import com.comco.exactcover.puzzles.PuzzleType;

public class ExactCover extends Puzzle {
	public boolean[][] matrix;
	private final List<ExactCoverAtom> atoms = new ArrayList<ExactCoverAtom>();
	private final List<ExactCoverSet> sets = new ArrayList<ExactCoverSet>();
	
	public ExactCover(boolean[][] matrix) {
		super(PuzzleType.EXACT_COVER);
		this.matrix = matrix;
		
		for (int col = 0; col < cols(); ++col) {
			atoms.add(new ExactCoverAtom(this, col));
		}
		
		for (int row = 0; row < rows(); ++row) {
			sets.add(new ExactCoverSet(this, row));
		}
	}
	
	@Override
	public Iterable<ExactCoverAtom> atoms() {
		return atoms;
	}

	@Override
	public Iterable<ExactCoverSet> sets() {
		return sets;
	}

	@Override
	public ExactCoverAtom getAtom(int id) {
		return atoms.get(id);
	}

	@Override
	public ExactCoverSet getSet(int id) {
		return sets.get(id);
	}

	@Override
	public ExactCoverSolution createSolution() {
		return new ExactCoverSolution(this);
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
