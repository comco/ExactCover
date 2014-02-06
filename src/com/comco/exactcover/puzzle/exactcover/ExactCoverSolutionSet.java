package com.comco.exactcover.puzzle.exactcover;

import java.util.ArrayDeque;

import com.comco.exactcover.AbstractSolutionSet;
import com.comco.exactcover.Row;
import com.comco.exactcover.cli.ProgramState;

public class ExactCoverSolutionSet extends AbstractSolutionSet {
	private final ExactCover exactCover;
	private final ArrayDeque<ExactCoverConstraint> stack = new ArrayDeque<>();

	public ExactCoverSolutionSet(ExactCover exactCover, ProgramState state) {
		super(state);
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
		if (!quiet) {
			printSolution();
		}
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
}
