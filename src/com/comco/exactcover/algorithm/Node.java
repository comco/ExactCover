package com.comco.exactcover.algorithm;

public abstract class Node {
	abstract Node getLeft();

	abstract void setLeft(final Node node);

	abstract Node getRight();

	abstract void setRight(final Node node);

	abstract Node getBottom();

	abstract void setBottom(final Node node);

	abstract Node getTop();

	abstract void setTop(final Node node);

	abstract ColumnNode getColumnNode();

	abstract Iterable<? extends Node> nodesOnRow();
	
	public Node createTop(final Row row) {
		Node node = new InternalNode(getColumnNode(), row);
		node.setTop(getTop());
		node.setBottom(this);
		getTop().setBottom(node);
		setTop(node);
		return node;
	}
	
	public Node insertRight(final Node node) {
		node.setRight(getRight());
		node.setLeft(this);
		getRight().setLeft(node);
		setRight(node);
		return node;
	}
	
	@Override
	public String toString() {
		// TODO: just for informative purposes
		return Integer.toString(System.identityHashCode(this) % 100);
	}
}
