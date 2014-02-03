package com.comco.exactcover.algorithm;

public class DegreeDancingLinks extends BasicDancingLinks {

	public DegreeDancingLinks(final ColumnNode head) {
		super(head);
	}

	@Override
	protected ColumnNode selectColumn() {
		ColumnNode resultNode = null;
		int minSize = Integer.MAX_VALUE;
		int ties = 0;
		for (ColumnNode node = head.right; node != head; node = node.right) {
			if (node.size < minSize) {
				minSize = node.size;
				resultNode = node;
				ties = 1;
			} else if (node.size == minSize) {
				++ties;
			}
		}

		if (minSize > 1 && ties > 1) {
			// break the tie using the degree heuristic
			// System.out.format("tie: %d %d\n", minSize, ties);
			int maxDegree = Integer.MIN_VALUE;
			for (ColumnNode node = head.right; node != head; node = node.right) {
				if (node.size == minSize) {
					final int degree = degree(node);
					if (degree > maxDegree) {
						// System.out.print("+");
						maxDegree = degree;
						resultNode = node;
						// } else if (degree == maxDegree) {
						// System.out.print("=");
					}
				}
			}
			// System.out.println();
		}
		return resultNode;
	}

	private int degree(final ColumnNode node) {
		int degree = 0;
		for (Node at = node.base.top; at != node.base; at = at.top) {
			degree += degree(at);
		}
		return degree;
	}

	private int degree(final Node node) {
		int degree = 0;
		for (Node at = node.right; at != node; at = at.right) {
			if (node.column.isAttached()) {
				++degree;
			}
		}
		return degree;
	}
}
