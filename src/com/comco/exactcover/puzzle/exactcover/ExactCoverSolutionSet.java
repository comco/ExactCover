package com.comco.exactcover.puzzle.exactcover;

import java.util.ArrayDeque;

import com.comco.exactcover.Row;
import com.comco.exactcover.SolutionSet;

public class ExactCoverSolutionSet implements SolutionSet {
	private final ExactCover exactCover;
	private final ArrayDeque<ExactCoverConstraint> stack = new ArrayDeque<>();
	private int numberOfSolutionsFound = 0;

	public ExactCoverSolutionSet(ExactCover exactCover) {
		this.exactCover = exactCover;
	}

	@Override
	public void addRow(Row row) {
		// cast is safe
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
		System.out.println("Solution found:");
		for (ExactCoverConstraint set : stack) {
			System.out.format("%d ", set.getRow());
		}
		System.out.println();
		++numberOfSolutionsFound;
	}

	@Override
	public boolean shouldContinue() {
		return true;
	}

	public ExactCover getExactCover() {
		return exactCover;
	}

	@Override
	public int getNumberOfSolutionsFound() {
		return numberOfSolutionsFound;
	}
}
