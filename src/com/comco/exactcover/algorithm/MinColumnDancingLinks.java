package com.comco.exactcover.algorithm;

public class MinColumnDancingLinks extends BasicDancingLinks {
	public MinColumnDancingLinks(final ColumnNode head) {
		super(head);
	}

	@Override
	protected ColumnNode selectColumn() {
		ColumnNode minNode = null;
		int minSize = Integer.MAX_VALUE;
		for (ColumnNode node = head.right; node != head; node = node.right) {
			if (minSize > node.size) {
				minSize = node.size;
				minNode = node;
			}
		}
		return minNode;
	}
}
