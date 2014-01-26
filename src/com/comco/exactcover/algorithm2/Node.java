package com.comco.exactcover.algorithm2;

public final class Node {
	Node left;
	Node right;
	Node bottom;
	Node top;
	final Column column;
	final Row row;

	public Node(final Column column, final Row row) {
		this.column = column;
		this.row = row;
		this.left = this;
		this.right = this;
		this.bottom = this;
		this.top = this;
	}

	public void attach() {
		bottom.top = this;
		top.bottom = this;
	}

	public void detach() {
		bottom.top = top;
		top.bottom = bottom;
	}

	public Node insertTop(final Node node) {
		node.top = top;
		top.bottom = node;
		node.bottom = this;
		top = node;
		return node;
	}
}
