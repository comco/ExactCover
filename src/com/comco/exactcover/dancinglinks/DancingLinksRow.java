package com.comco.exactcover.dancinglinks;

import java.util.Iterator;

import com.comco.common.MapIteratorDecorator;
import com.comco.exactcover.Row;

public class DancingLinksRow implements Row, Iterable<Node> {
	private final Node origin;

	public DancingLinksRow(final Node origin) {
		this.origin = origin;
	}

	@Override
	public Iterator<Node> iterator() {
		return this.new RowIterator();
	}

	public void attach() {
		for (final Node node : this) {
			node.attachBottomTop();
		}
	}

	public void detach() {
		for (final Node node : this) {
			node.detachBottomTop();
		}
	}

	public Iterable<DancingLinksCol> incidentCols() {
		return new Iterable<DancingLinksCol>() {

			@Override
			public Iterator<DancingLinksCol> iterator() {
				return new MapIteratorDecorator<Node, DancingLinksCol>(
						DancingLinksRow.this.iterator()) {

					@Override
					protected DancingLinksCol transform(final Node node) {
						return new DancingLinksCol(node);
					}

				};
			}

		};
	}

	private class RowIterator implements Iterator<Node> {
		private Node at = origin;
		private boolean visitedOrigin = false;

		@Override
		public boolean hasNext() {
			return !(visitedOrigin && at == origin);
		}

		@Override
		public Node next() {
			final Node result = at;
			if (at == origin) {
				visitedOrigin = true;
			}
			at = at.getRight();
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Can't remove elements from dancing links row iterator.");
		}
	}
}
