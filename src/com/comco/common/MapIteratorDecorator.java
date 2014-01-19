package com.comco.common;

import java.util.Iterator;

public abstract class MapIteratorDecorator<Source, Destination> implements
		Iterator<Destination> {
	private final Iterator<Source> sourceIterator;

	public MapIteratorDecorator(final Iterator<Source> sourceIterator) {
		this.sourceIterator = sourceIterator;
	}

	@Override
	public boolean hasNext() {
		return sourceIterator.hasNext();
	}

	@Override
	public Destination next() {
		return transform(sourceIterator.next());
	}

	@Override
	public void remove() {
		sourceIterator.remove();
	}

	protected abstract Destination transform(final Source source);
}
