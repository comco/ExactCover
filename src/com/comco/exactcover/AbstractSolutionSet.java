package com.comco.exactcover;

public abstract class AbstractSolutionSet implements SolutionSet {
	private int numberOfSolutionsFound = 0;
	private int examinedNodes = 0;
	
	@Override
	public void addRow(Row row) {
		++examinedNodes;
	}

	@Override
	public void complete() {
		++numberOfSolutionsFound;
	}

	@Override
	public boolean shouldContinue() {
		return true;
	}

	@Override
	public int getNumberOfSolutionsFound() {
		return numberOfSolutionsFound;
	}
	
	public int getExaminedNodes() {
		return examinedNodes;
	}
}
