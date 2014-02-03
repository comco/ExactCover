package com.comco.exactcover;

import com.comco.exactcover.algorithm.ColumnNode;

public abstract class AbstractSolutionSet implements SolutionSet {
	private int numberOfSolutionsFound = 0;
	private int examinedNodes = 0;
	private int examinedColumns = 0;

	@Override
	public void addColumn(ColumnNode column) {
		++examinedColumns;
	}

	@Override
	public void popColumn() {
		// do nothing
	}

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

	@Override
	public int getExaminedNodes() {
		return examinedNodes;
	}

	@Override
	public int getExaminedColumns() {
		return examinedColumns;
	}
}
