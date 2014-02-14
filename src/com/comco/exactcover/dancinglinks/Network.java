package com.comco.exactcover.dancinglinks;

public class Network {
	final ColumnNode head;

	public Network(final ColumnNode head) {
		assert (head.isHead());
		this.head = head;
	}

	public ColumnNode head() {
		return head;
	}
}
