package com.comco.exactcover.puzzle.polymino;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.gui.SolutionKnitterModel;

public class PolyminoModel extends SolutionKnitterModel {
	private final PolyminoSolutionKnitter solutionSet;
	private final ArrayDeque<PiecePart> constraints = new ArrayDeque<>();
	private PiecePart pop;

	public PolyminoModel(PolyminoSolutionKnitter solutionSet) {
		super(solutionSet);
		this.solutionSet = solutionSet;
	}

	@Override
	public void addRow(Row row) {
		constraints.add((PiecePart) row);
		super.addRow(row);
		pop = null;
	}

	@Override
	public void popRow() {
		super.popRow();
		pop = constraints.pop();
	}

	public PiecePart getPopped() {
		return pop;
	}

	public PiecePart getCurrentConstraint() {
		return constraints.peekLast();
	}

	public int getRows() {
		return solutionSet.getPolymino().boardRows();
	}

	public int getCols() {
		return solutionSet.getPolymino().boardCols();
	}

	public int getNumberOfPieces() {
		return solutionSet.getPolymino().getNumberOfPieces();
	}

	public int getPieceIdAt(int row, int col) {
		return solutionSet.getPieceIdAt(row, col);
	}

	public boolean[][] board() {
		return solutionSet.getPolymino().getBoard();
	}
}
