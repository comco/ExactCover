package com.comco.exactcover.puzzle;

import java.util.List;

import com.comco.exactcover.algorithm.ColumnNode;
import com.comco.exactcover.algorithm.Node;

public abstract class Puzzle {
	private int nextAtomId = 0;
	private int nextConstraintId = 0;
	
	int nextAtomId() {
		return nextAtomId++;
	}
	
	int nextConstraintId() {
		return nextConstraintId++;
	}
	
	protected abstract List<? extends PuzzleAtom> atoms();
	protected abstract List<? extends PuzzleConstraint> constraints();
	
	public boolean[][] toBooleanMatrix() {
		final boolean[][] matrix = new boolean[constraints().size()][atoms().size()];
		for (PuzzleConstraint constraint : constraints()) {
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
		Node[] horizon = new Node[atoms().size()];
		int i = 0;
		for (final PuzzleAtom atom : atoms()) {
			tail = tail.createRight(atom);
			horizon[i++] = tail;
		}
		// create constraints
		for (final PuzzleConstraint constraint : constraints()) {
			for (final PuzzleAtom atom : constraint.atoms()) {
				horizon[atom.id] = horizon[atom.id].createTop(constraint);
			}
		}
		return head;
	}
}
