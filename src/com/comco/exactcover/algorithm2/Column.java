package com.comco.exactcover.algorithm2;

public final class Column {
	final Node base;
	Column left;
	Column right;
	int size = 0;

	public Column() {
		base = new Node(this, null);
		left = this;
		right = this;
	}

	public void attach() {
		left.right = this;
		right.left = this;
	}

	public void detach() {
		left.right = right;
		right.left = left;
	}

	public Column insertRight(final Column column) {
		column.right = right;
		right.left = column;
		column.left = this;
		right = column;
		return column;
	}

	public boolean isUnit() {
		return (this == right);
	}
}
