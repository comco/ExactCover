package com.comco.exactcover.puzzles;

import com.comco.exactcover.Solution;

public abstract class Puzzle {
	public final PuzzleType type;
	
	protected Puzzle(final PuzzleType type) {
		this.type = type;
	}
	
	private int nextAtomId = 0;
	private int nextSetId = 0;

	public int nextAtomId() {
		return nextAtomId++;
	}

	public int nextSetId() {
		return nextSetId++;
	}

	public int atomsCount() {
		return nextAtomId;
	}

	public int setsCount() {
		return nextSetId;
	}

	public abstract Iterable<? extends PuzzleAtom> atoms();
	
	public abstract Iterable<? extends PuzzleSet> sets();

	public abstract PuzzleAtom getAtom(int id);
	
	public abstract PuzzleSet getSet(int id);
	
	/**
	 * Transforms the puzzle to an exact cover problem.
	 * 
	 * @return
	 */
	public boolean[][] toExactCover() {
		boolean[][] result = new boolean[setsCount()][atomsCount()];
		
		for (PuzzleSet set : sets()) {
			for (PuzzleAtom atom : set.atoms()) {
				result[set.id][atom.id] = true;
			}
		}

		return result;
	}
	
	public abstract Solution createSolution();
}
