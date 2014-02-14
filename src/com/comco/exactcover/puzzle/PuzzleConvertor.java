package com.comco.exactcover.puzzle;

import com.comco.exactcover.dancinglinks.ColumnNode;
import com.comco.exactcover.dancinglinks.Network;
import com.comco.exactcover.dancinglinks.Node;

public class PuzzleConvertor {
	private PuzzleConvertor() {

	}

	public static final PuzzleConvertor INSTANCE = new PuzzleConvertor();

	public Network convertToNetwork(final Puzzle puzzle) {
		// create head
		final ColumnNode head = ColumnNode.createHeadColumnNode();
		ColumnNode tail = head;

		// create columns
		ColumnNode[] columnNodes = new ColumnNode[puzzle.atoms().size()];
		int i = 0;
		for (final PuzzleAtom atom : puzzle.atoms()) {
			tail = tail.createRight(atom);
			columnNodes[i++] = tail;
		}

		// create constraints
		Node[] sweep = new Node[puzzle.atoms().size()];
		for (int j = 0; j < puzzle.atoms().size(); ++j) {
			sweep[j] = columnNodes[j].base();
		}
		for (final PuzzlePart constraint : puzzle.parts()) {
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
		return new Network(head);
	}

	public boolean[][] convertToBooleanMatrix(final Puzzle puzzle) {
		final boolean[][] matrix = new boolean[puzzle.parts().size()][puzzle
				.atoms().size()];
		for (final PuzzlePart constraint : puzzle.parts()) {
			for (PuzzleAtom atom : constraint.atoms()) {
				matrix[constraint.id][atom.id] = true;
			}
		}
		return matrix;
	}
}
