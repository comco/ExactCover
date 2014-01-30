package com.comco.exactcover.puzzle;

import java.util.ArrayList;
import java.util.List;

import com.comco.exactcover.algorithm.ColumnNode;
import com.comco.exactcover.algorithm.Node;

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
		ColumnNode[] columnNodes = new ColumnNode[atoms.size()];
		int i = 0;
		for (final PuzzleAtom atom : atoms) {
			tail = tail.createRight(atom);
			columnNodes[i++] = tail;
		}

		// create constraints
		Node[] sweep = new Node[atoms.size()];
		for (int j = 0; j < atoms.size(); ++j) {
			sweep[j] = columnNodes[j].base();
		}
		for (final PuzzleConstraint constraint : constraints) {
			Node left = null;
			for (final PuzzleAtom atom : constraint.atoms()) {
				sweep[atom.id] = sweep[atom.id].createTop(constraint);
				if (left == null) {
					left = sweep[atom.id];
				} else {
					left = left.insertRight(sweep[atom.id]);
				}
			}
		}
		return head;
	}
}
