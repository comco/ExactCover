package com.comco.exactcover;

public interface Solution {
	void includeRow(final Row row);
	void excludeRow(final Row row);
	void declareConcrete();
}
