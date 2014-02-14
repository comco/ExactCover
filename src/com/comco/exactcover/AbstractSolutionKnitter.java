package com.comco.exactcover;

public abstract class AbstractSolutionKnitter implements SolutionKnitter {
	private int addedRowsCount = 0;
	private int addedColsCount = 0;
	private int foundSolutionsCount = 0;

	@Override
	public void addRow(Row row) {
		++addedRowsCount;
	}

	@Override
	public void addCol(Col col) {
		++addedColsCount;
	}

	@Override
	public void popCol() {
		// do nothing.
	}

	@Override
	public void complete() {
		++foundSolutionsCount;
	}

	@Override
	public boolean shouldContinue() {
		return true;
	}

	@Override
	public int addedRowsCount() {
		return addedRowsCount;
	}

	@Override
	public int addedColsCount() {
		return addedColsCount;
	}

	@Override
	public int foundSolutionsCount() {
		return foundSolutionsCount;
	}

}
