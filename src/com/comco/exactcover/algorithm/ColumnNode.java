package com.comco.exactcover.algorithm;

import com.comco.exactcover.Column;

public final class ColumnNode {
	final Node base;
	final Column column;
	ColumnNode left;
	ColumnNode right;
	int size = 0;

	private ColumnNode(final Column column) {
		this.base = new Node(this, null);
		this.column = column;
		this.left = this;
		this.right = this;
	}

	public Node base() {
		return base;
	}

	public void attach() {
		left.right = this;
		right.left = this;
	}

	public void detach() {
		left.right = right;
		right.left = left;
	}

	public boolean isAttached() {
		return left.right == this;
	}

	public ColumnNode insertRight(final ColumnNode column) {
		column.right = right;
		right.left = column;
		column.left = this;
		right = column;
		return column;
	}

	boolean isUnit() {
		return (this == right);
	}

	public ColumnNode createRight(final Column column) {
		return insertRight(new ColumnNode(column));
	}

	public int id() {
		return System.identityHashCode(this) % 256;
	}

	public String dump() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("[%02X]: ", id()));
		sb.append(base.dump());
		for (Node node = base.top; node != base; node = node.top) {
			sb.append(node.dump() + ' ');
		}
		sb.append('\n');
		return sb.toString();
	}

	public String dumpHead() {
		StringBuilder sb = new StringBuilder();
		for (ColumnNode node = right; node != this; node = node.right) {
			sb.append(node.dump());
		}
		return sb.toString();
	}

	public static ColumnNode createHeadColumnNode() {
		return new ColumnNode(null);
	}
}
