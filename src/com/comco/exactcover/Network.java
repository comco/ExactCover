package com.comco.exactcover;

import com.comco.exactcover.algorithm.ColumnNode;

public class Network {
	public final ColumnNode head;
	public final ColumnNode[] columnNodes;

	public Network(final ColumnNode head, final ColumnNode[] columnNodes) {
		this.head = head;
		this.columnNodes = columnNodes;
	}
}
