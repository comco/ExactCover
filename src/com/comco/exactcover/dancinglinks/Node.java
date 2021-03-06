package com.comco.exactcover.dancinglinks;

import com.comco.exactcover.Row;

public final class Node {
	Node left, right, bottom, top;
	final ColumnNode column;
	final Row row;

	Node(final ColumnNode column, final Row row) {
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
		++column.size;
	}

	public void detach() {
		bottom.top = top;
		top.bottom = bottom;
		--column.size;
	}

	public Node insertTop(final Node node) {
		node.top = top;
		top.bottom = node;
		node.bottom = this;
		top = node;
		++column.size;
		return node;
	}

	public Node createTop(final Row row) {
		return insertTop(new Node(column, row));
	}

	public Node insertRight(final Node node) {
		node.right = right;
		node.left = this;
		right.left = node;
		right = node;
		return node;
	}

	public int id() {
		return System.identityHashCode(this) % 256;
	}

	public String dump() {
		return String.format("(%02X | %02X | %02X)", left.id(), id(),
				right.id());
	}

	static Node createBaseNode(final ColumnNode column) {
		return new Node(column, null);
	}
}
