package com.comco.exactcover;

public interface SolutionKnitter {
	void addRow(final Row row);

	void popRow();

	void addCol(final Col col);

	void popCol();

	void complete();

	boolean shouldContinue();

	int addedRowsCount();

	int addedColsCount();

	int foundSolutionsCount();
}
