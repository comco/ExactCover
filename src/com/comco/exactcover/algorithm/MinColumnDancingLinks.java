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

	@SuppressWarnings("unused")
	private int columnSize(final ColumnNode columnNode) {
		int size = 0;
		for (Node node = columnNode.base.top; node != columnNode.base; node = node.top) {
			++size;
		}
		return size;
	}
}
