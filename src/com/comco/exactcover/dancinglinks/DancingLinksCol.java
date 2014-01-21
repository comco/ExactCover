package com.comco.exactcover.dancinglinks;

import java.util.Iterator;

import com.comco.common.MapIteratorDecorator;
import com.comco.exactcover.Col;

/**
 * A column in the Dancing Link representation of the Exact Cover problem.
 * 
 * @author comco
 * 
 */
public class DancingLinksCol implements Col, Iterable<Node> {
	private final Node origin;

	public DancingLinksCol(final Node origin) {
		this.origin = origin;
	}

	@Override
	public Iterator<Node> iterator() {
		return this.new ColIterator();
	}

	@Override
	public void attach() {
		for (final Node node : this) {
			node.attachLeftRight();
		}
	}

	@Override
	public void detach() {
		for (final Node node : this) {
			node.detachLeftRight();
		}
	}

	@Override
	public Iterable<DancingLinksRow> incidentRows() {
		return new Iterable<DancingLinksRow>() {

			@Override
			public Iterator<DancingLinksRow> iterator() {
				return new MapIteratorDecorator<Node, DancingLinksRow>(
						DancingLinksCol.this.iterator()) {

					@Override
					protected DancingLinksRow transform(final Node node) {
						return new DancingLinksRow(node);
					}

				};
			}

		};
	}

	private class ColIterator implements Iterator<Node> {
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
			at = at.getTop();
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Can't remove elements from dancing links column iterator.");
		}
	}
}
