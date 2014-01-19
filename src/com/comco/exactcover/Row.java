package com.comco.exactcover;

/**
 * Represents a coverable set in the exact cover problem.
 * 
 * @author comco
 * 
 */
public interface Row {
	/**
	 * Attaches the row to its network.
	 */
	void attach();

	/**
	 * Detaches the row from its network.
	 */
	void detach();

	/**
	 * Enumerates the incident columns to this row.
	 * 
	 * @return columns enumeration.
	 */
	Iterable<? extends Col> incidentCols();
}
