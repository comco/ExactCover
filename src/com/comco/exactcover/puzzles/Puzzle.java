package com.comco.exactcover.puzzles;

public abstract class Puzzle {
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
		boolean[][] result = new boolean[atomsCount()][setsCount()];
		for (PuzzleSet set : sets()) {
			for (PuzzleAtom atom : set.atoms()) {
				result[atom.id][set.id] = true;
			}
		}

		return result;
	}
}