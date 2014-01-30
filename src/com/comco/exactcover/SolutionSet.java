package com.comco.exactcover;

public interface SolutionSet {

	void addRow(final Row row);

	void popRow();

	void complete();

	boolean shouldContinue();
}
