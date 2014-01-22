package com.comco.exactcover.algorithm;

public interface SolutionSet {
	void addRow(final Row row);
	void pop();
	void complete();
	
	boolean shouldContinue();
}
