package com.comco.exactcover;

/**
 * Represents a partial dynamic solution to the exact cover problem.
 * 
 * @author comco
 * 
 */
public interface Solution {
	/**
	 * Includes a row to the partial solution.
	 * 
	 * @param row
	 *            - the row to include
	 */
	void includeRow(final Row row);

	/**
	 * Excludes the last row from the partial solution.
	 */
	void excludeRow();

	/**
	 * Declares the current partial solution to be a concrete, full solution of
	 * the exact cover problem.
	 */
	void declareConcrete();
}
