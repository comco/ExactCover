package com.comco.exactcover.puzzle;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.algorithm.ColumnNode;
import com.comco.exactcover.algorithm.Node;
import com.comco.exactcover.algorithm2.Column;

public abstract class Puzzle {
	private int nextAtomId = 0;
	private int nextConstraintId = 0;

	private final List<PuzzleAtom> atoms = new ArrayList<PuzzleAtom>();
	private final List<PuzzleConstraint> constraints = new ArrayList<PuzzleConstraint>();

	public Iterable<PuzzleAtom> allAtoms() {
		return atoms;
	}

	public Iterable<PuzzleConstraint> allConstraints() {
		return constraints;
	}

	public int atomsCount() {
		return atoms.size();
	}

	public int constraintsCount() {
		return constraints.size();
	}

	void addAtom(final PuzzleAtom atom) {
		atoms.add(atom);
	}

	void addConstraint(final PuzzleConstraint constraint) {
		constraints.add(constraint);
	}

	int nextAtomId() {
		return nextAtomId++;
	}

	int nextConstraintId() {
		return nextConstraintId++;
	}

	public boolean[][] toBooleanMatrix() {
		final boolean[][] matrix = new boolean[constraints.size()][atoms.size()];
		for (final PuzzleConstraint constraint : constraints) {
			for (PuzzleAtom atom : constraint.atoms()) {
				matrix[constraint.id][atom.id] = true;
			}
		}
		return matrix;
	}

	public ColumnNode toNetwork() {
		// create head
		final ColumnNode head = ColumnNode.createHeadColumnNode();
		ColumnNode tail = head;

		// create columns
		Node[] horizon = new Node[atoms.size()];
		int i = 0;
		for (final PuzzleAtom atom : atoms) {
			tail = tail.createRight(atom);
			horizon[i++] = tail;
		}

		// create constraints
		for (final PuzzleConstraint constraint : constraints) {
			Node left = null;
			for (final PuzzleAtom atom : constraint.atoms()) {
				horizon[atom.id] = horizon[atom.id].createTop(constraint);
				if (left == null) {
					left = horizon[atom.id];
				} else {
					left = left.insertRight(horizon[atom.id]);
				}
			}
		}
		return head;
	}
}
