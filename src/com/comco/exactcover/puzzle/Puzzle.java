package com.comco.exactcover.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Puzzle {
	private final List<PuzzleAtom> atoms = new ArrayList<PuzzleAtom>();
	private final List<PuzzlePart> parts = new ArrayList<PuzzlePart>();

	public List<PuzzleAtom> atoms() {
		return Collections.unmodifiableList(atoms);
	}

	public List<PuzzlePart> parts() {
		return Collections.unmodifiableList(parts);
	}
	
	private int nextAtomId = 0;
	private int nextPartId = 0;

	int nextAtomId() {
		return nextAtomId++;
	}

	int nextPartId() {
		return nextPartId++;
	}
	
	void addAtom(final PuzzleAtom atom) {
		atoms.add(atom);
	}

	void addPart(final PuzzlePart part) {
		parts.add(part);
	}
}
