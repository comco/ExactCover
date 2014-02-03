package com.comco.exactcover.algorithm;

public class DegreeDancingLinks extends BasicDancingLinks {

	public DegreeDancingLinks(final ColumnNode head) {
		super(head);
	}
	
	@Override
	protected ColumnNode selectColumn() {
		ColumnNode minNode = null;
		int minSize = Integer.MAX_VALUE;
		int ties = 0;
		for (ColumnNode node = head.right; node != head; node = node.right) {
			if (minSize > node.size) {
				minSize = node.size;
				minNode = node;
				ties = 1;
			} else if (minSize == node.size) {
				++ties;
			}
		}
		
		if (minSize > 1 && ties > 1) {
			// break the tie using the degree heuristic
			int maxDegree = Integer.MAX_VALUE;
			for (ColumnNode node = head.right; node != head; node = node.right) {
				if (node.size == minSize) {
					final int degree = degree(node);
					if (degree < maxDegree) {
						System.out.println("opt");
						maxDegree = degree;
						minNode = node;
					}
				}
			}
		}
		return minNode;
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
			if (at.column.isAttached()) {
				++degree;
			}
		}
		return degree;
	}
}
