package com.comco.exactcover;

/**
 * Represents an exact cover problem.
 * 
 * @author comco
 * 
 */
public interface Network {
	/**
	 * Checks if the network has rows.
	 * 
	 * @return
	 */
	public boolean hasRows();

	/**
	 * Checks if the network has columns.
	 * 
	 * @return
	 */
	public boolean hasCols();

}
