package com.comco.exactcover.puzzle.polymino;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.gui.SolutionSetModel;

public class PolyminoModel extends SolutionSetModel {
	private final PolyminoSolutionSet solutionSet;
	private final ArrayDeque<PieceConstraint> constraints = new ArrayDeque<>();
	private PieceConstraint pop;

	public PolyminoModel(PolyminoSolutionSet solutionSet) {
		super(solutionSet);
		this.solutionSet = solutionSet;
	}

	@Override
	public void addRow(Row row) {
		constraints.add((PieceConstraint) row);
		super.addRow(row);
		pop = null;
	}

	@Override
	public void popRow() {
		super.popRow();
		pop = constraints.pop();
	}

	public PieceConstraint getPopped() {
		return pop;
	}

	public PieceConstraint getCurrentConstraint() {
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
