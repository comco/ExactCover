package com.comco.exactcover.puzzles;

import java.util.ArrayList;
import java.util.List;

public abstract class Puzzle {
	private int nextAtomId = 0;
	private int nextSetId = 0;
	private List<PuzzleAtom> atoms = new ArrayList<PuzzleAtom>();
	private List<PuzzleSet> sets = new ArrayList<PuzzleSet>();

	public int nextAtomId() {
		return nextAtomId++;
	}

	public int nextSetId() {
		return nextSetId++;
	}

	void addAtom(final PuzzleAtom atom) {
		atoms.add(atom);
	}

	void addSet(final PuzzleSet set) {
		sets.add(set);
	}

	public int atomsCount() {
		return nextAtomId;
	}

	public int setsCount() {
		return nextSetId;
	}

	/**
	 * Transforms the puzzle to an exact cover problem.
	 * 
	 * @return
	 */
	public boolean[][] toExactCover() {
		boolean[][] result = new boolean[atoms.size()][sets.size()];
		for (PuzzleSet set : sets) {
			for (PuzzleAtom atom : set.atoms()) {
				result[atom.id][set.id] = true;
			}
		}

		return result;
	}
}
