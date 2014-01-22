package com.comco.exactcover.algorithm;

public interface Node {
	Node getLeft();

	void setLeft(final Node node);

	Node getRight();

	void setRight(final Node node);

	Node getBottom();

	void setBottom(final Node node);

	Node getTop();

	void setTop(final Node node);

	ColumnNode getColumnNode();

	Iterable<? extends Node> nodesOnRow();
}
