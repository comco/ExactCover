package com.comco.exactcover.puzzle.exactcover;

import java.util.Stack;

import com.comco.exactcover.algorithm.Row;
import com.comco.exactcover.algorithm.SolutionSet;

public class ExactCoverSolution implements SolutionSet {
	private final ExactCover exactCover;
	private final Stack<ExactCoverConstraint> stack = new Stack<>();
	
	public ExactCoverSolution(ExactCover exactCover) {
		this.exactCover = exactCover;
	}
	
	@Override
	public void addRow(Row row) {
		// cast is safe
		addConstraint((ExactCoverConstraint) row);
	}
	
	private void addConstraint(final ExactCoverConstraint constraint) {
		System.out.println("adding " + constraint.row);
	}

	@Override
	public void pop() {
		stack.pop();
	}

	@Override
	public void complete() {
		System.out.println("Solution found:");
		for (ExactCoverConstraint set : stack) {
			System.out.format("%d ", set.row);
		}
		System.out.println();
	}

	@Override
	public boolean shouldContinue() {
		return true;
	}

	public ExactCover getExactCover() {
		return exactCover;
	}
}
