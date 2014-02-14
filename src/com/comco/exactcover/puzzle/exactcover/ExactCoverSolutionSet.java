package com.comco.exactcover.puzzle.exactcover;

import java.util.ArrayDeque;

import com.comco.exactcover.AbstractSolutionKnitter;
import com.comco.exactcover.Row;

public class ExactCoverSolutionSet extends AbstractSolutionKnitter {
	private final ExactCover exactCover;
	private final ArrayDeque<ExactCoverConstraint> stack = new ArrayDeque<>();

	public ExactCoverSolutionSet(ExactCover exactCover) {
		super();
		this.exactCover = exactCover;
	}

	@Override
	public void addRow(Row row) {
		// cast is safe
		super.addRow(row);
		addConstraint((ExactCoverConstraint) row);
	}

	private void addConstraint(final ExactCoverConstraint constraint) {
		stack.add(constraint);
	}

	@Override
	public void popRow() {
		stack.pop();
	}

	@Override
	public void complete() {
		super.complete();
		printSolution();
	}

	private void printSolution() {
		System.out.println("Solution found:");
		for (ExactCoverConstraint set : stack) {
			System.out.format("%d ", set.getRow());
		}
		System.out.println();
	}

	public ExactCover getExactCover() {
		return exactCover;
	}

	@Override
	public void popCol() {
		// TODO Auto-generated method stub

	}
}
