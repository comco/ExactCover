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
}
