package com.comco.exactcover.puzzle.polymino;

/**
 * An atom signifying that a position should be filled exactly once.
 * 
 * @author comco
 * 
 */
public class PositionAtom extends PolyminoAtom {
	public final int row;
	public final int col;

	public PositionAtom(final Polymino puzzle, final int row, final int col) {
		super(puzzle);
		this.row = row;
		this.col = col;
	}
}
