package com.comco.exactcover.dancinglinks;

import java.util.Iterator;

public class Network {
	final ColumnNode head;

	public Network(final ColumnNode head) {
		assert (head.isHead());
		this.head = head;
	}

	public ColumnNode head() {
		return head;
	}

	public Iterable<ColumnNode> columnNodes() {
		return new Iterable<ColumnNode>() {

			@Override
			public Iterator<ColumnNode> iterator() {
				return new Iterator<ColumnNode>() {
					private ColumnNode at = head.right;

					@Override
					public boolean hasNext() {
						return at != head;
					}

					@Override
					public ColumnNode next() {
						ColumnNode node = at;
						at = at.right;
						return node;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException(
								"Cannot delete column nodes.");
					}

				};
			}

		};
	}
}
