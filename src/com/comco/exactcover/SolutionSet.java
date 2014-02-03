package com.comco.exactcover;

import com.comco.exactcover.algorithm.ColumnNode;

public interface SolutionSet {
	void addColumn(final ColumnNode column);

	void popColumn();

	void addRow(final Row row);

	void popRow();

	void complete();

	boolean shouldContinue();

	int getNumberOfSolutionsFound();

	int getExaminedNodes();

	int getExaminedColumns();
}
