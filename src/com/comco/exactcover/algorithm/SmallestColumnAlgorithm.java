package com.comco.exactcover.algorithm;

public class SmallestColumnAlgorithm extends Algorithm {
	@Override
	protected ColumnNode selectColumn(ColumnNode head) {
		int minSize = Integer.MAX_VALUE;
		ColumnNode node = null;
		for (final ColumnNode columnNode : head.nodesOnRow()) {
			// int columnSize = columnSize(columnNode);
			int columnSize = columnNode.size;
			if (columnNode.size != columnSize(columnNode)) {
				throw new IllegalStateException("asds");
			}
			if (columnSize < minSize) {
				minSize = columnSize;
				node = columnNode;
			}
		}
		return node;
	}

	private int columnSize(final ColumnNode columnNode) {
		int size = 0;
		// need the number of rows in a column node
		for (@SuppressWarnings("unused")
		final Node at : columnNode.nodesOnColumn()) {
			++size;
		}
		return size;
	}
}
