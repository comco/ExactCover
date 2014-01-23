package com.comco.exactcover.algorithm;

import java.util.Iterator;

public class ColumnNode extends Node {
	private final Column column;
	private ColumnNode left, right;
	private Node bottom, top;

	ColumnNode(final Column column) {
		this.column = column;
		left = this;
		right = this;
		bottom = this;
		top = this;
	}
	
	public ColumnNode createRight(final Column column) {
		final ColumnNode node = new ColumnNode(column);
		node.left = this;
		node.right = right;
		right.left = node;
		right = node;
		return node;
	}
	
	public Column getColumn() {
		return column;
	}

	@Override
	public ColumnNode getLeft() {
		return left;
	}
	
	@Override
	public void setLeft(final Node node) {
		left = (ColumnNode) node;
	}

	@Override
	public ColumnNode getRight() {
		return right;
	}
	
	@Override
	public void setRight(final Node node) {
		right = (ColumnNode) node;
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
	
	@Override
	public ColumnNode getColumnNode() {
		return this;
	}

	public void detachLeftRight() {
		left.setRight(right);
		right.setLeft(left);
	}
	
	public void attachLeftRight() {
		left.setRight(this);
		right.setLeft(this);
	}
	
	public boolean isUnit() {
		return this == right;
	}

	public static ColumnNode createHeadColumnNode() {
		return new ColumnNode(new HeadColumn());
	}
	
	@Override
	public Iterable<ColumnNode> nodesOnRow() {
		return new Iterable<ColumnNode>() {

			@Override
			public Iterator<ColumnNode> iterator() {
				return new Iterator<ColumnNode>() {
					private ColumnNode current = ColumnNode.this.right;

					@Override
					public boolean hasNext() {
						return (current != ColumnNode.this);
					}

					@Override
					public ColumnNode next() {
						final ColumnNode node = current;
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

	public Iterable<InternalNode> nodesOnColumn() {
		return new Iterable<InternalNode>() {

			@Override
			public Iterator<InternalNode> iterator() {
				return new Iterator<InternalNode>() {
					private Node current = ColumnNode.this.top;

					@Override
					public boolean hasNext() {
						return (current != ColumnNode.this);
					}

					@Override
					public InternalNode next() {
						// cast is safe
						final InternalNode node = (InternalNode) current;
						current = current.getTop();
						return node;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException(
								"Column removal is unsupported.");
					}
				};
			}
		};
	}
	
	public String dump() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Dumping head: " + this + "\n");
		for (final ColumnNode column : nodesOnRow()) {
			sb.append("Column: " + column + "\n");
			for (final Node node : column.nodesOnColumn()) {
				sb.append("   Row: " + node + ", left: " + node.getLeft() + ", right: " + node.getRight() + "\n");
			}
		}
		return sb.toString();
	}
}