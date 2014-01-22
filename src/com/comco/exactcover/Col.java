package com.comco.exactcover;

/**
 * Represents an element of the exact cover problem.
 * 
 * @author comco
 * 
 */
public interface Col {
	/**
	 * Attaches the column to its network.
	 */
	void attach();

	/**
	 * Detaches the column from its network.
	 */
	void detach();

	/**
	 * Enumerates the incident rows of this column.
	 * 
	 * @return rows enumeration.
	 */
	Iterable<? extends Row> incidentRows();
	
	int col();
}
