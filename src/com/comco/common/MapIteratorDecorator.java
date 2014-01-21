package com.comco.common;

import java.util.Iterator;

/**
 * Higher-order map function for iterators.
 * 
 * @author comco
 * 
 * @param <Source>
 *            - the source type of the transformation
 * @param <Destination>
 *            - the destination type of the transformation
 */
public abstract class MapIteratorDecorator<Source, Destination> implements
	Iterator<Destination> {
    private final Iterator<Source> sourceIterator;

    /**
     * Constructs a new map iterator out of a given source iterator.
     * 
     * @param sourceIterator
     *            - the source iterator
     */
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

    /**
     * The transformation applied to each element of an iterator.
     * 
     * @param source
     *            - the element to be transformed
     * @return the transformed element.
     */
    protected abstract Destination transform(final Source source);
}
