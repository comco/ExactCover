package com.comco.exactcover.algorithm;

import java.util.Iterator;

public class InternalNode extends Node {
	private InternalNode left, right;
	private Node bottom, top;
	private final ColumnNode columnNode;
	private final Row row;

	InternalNode(final ColumnNode columnNode, final Row row) {
		this.columnNode = columnNode;
		this.row = row;
		this.left = this;
		this.right = this;
		this.bottom = this;
		this.top = this;
	}

	@Override
	public InternalNode getLeft() {
		return left;
	}

	@Override
	public void setLeft(final Node node) {
		left = (InternalNode) node;
	}

	@Override
	public InternalNode getRight() {
		return right;
	}

	@Override
	public void setRight(final Node node) {
		right = (InternalNode) node;
	}

	@Override
	public Node getBottom() {
		return bottom;
	}

	@Override
	public void setBottom(final Node node) {
		bottom = node;
	}

	@Override
	public Node getTop() {
		return top;
	}

	@Override
	public void setTop(final Node node) {
		top = node;
	}

	public Row getRow() {
		return row;
	}

	@Override
	public ColumnNode getColumnNode() {
		return columnNode;
	}

	public void detachBottomTop() {
		bottom.setTop(top);
		top.setBottom(bottom);
		--columnNode.size;
	}

	public void attachBottomTop() {
		bottom.setTop(this);
		top.setBottom(this);
		++columnNode.size;
	}

	@Override
	public Iterable<InternalNode> nodesOnRow() {
		return new Iterable<InternalNode>() {

			@Override
			public Iterator<InternalNode> iterator() {
				return new Iterator<InternalNode>() {
					private InternalNode current = InternalNode.this.right;

					@Override
					public boolean hasNext() {
						return (current != InternalNode.this);
					}

					@Override
					public InternalNode next() {
						final InternalNode node = current;
						current = current.right;
						return node;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException(
								"Row removal is unsupported.");
					}
				};
			}
		};
	}
}
