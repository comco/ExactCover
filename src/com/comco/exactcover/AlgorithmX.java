package com.comco.exactcover;

import java.util.ArrayList;

/**
 * Abstract class implementing Knuth's Algorithm X. Generates all solutions.
 * Concrete heuristics can be implemented in subclasses.
 * 
 * @author comco
 * 
 */
public abstract class AlgorithmX<SpecificNetwork extends Network> {

	/**
	 * Solves an exact cover problem, represented by a network.
	 * 
	 * @param network
	 *            - represents an exact cover problem
	 * @param partialSolution
	 *            - stores the solutions found
	 */
	public void solve(final SpecificNetwork network,
			final Solution partialSolution) {
		if (network.hasRows()) {
			if (network.hasCols()) {
				// choose a column deterministically
				Col col = chooseCol(network);
				// choose a row non-deterministically
				for (final Row row : enumerateRows(col)) {
					if (row.row() >= 0) {
						partialSolution.includeRow(row);
	
						// remove incident rows and columns
						ArrayList<Col> excludingCols = new ArrayList<>();
						ArrayList<Row> excludingRows = new ArrayList<>();
						for (final Col excludingCol : row.incidentCols()) {
							if (excludingCol.col() >= 0) {
								for (final Row excludingRow : excludingCol
										.incidentRows()) {
									if (excludingRow.row() >= 0) {
										excludingRows.add(row);
									}
								}
								excludingCols.add(excludingCol);
							}
						}
						
						for (Row excludingRow : excludingRows) {
							excludingRow.detach();
						}						
						for (Col excludingCol : excludingCols) {
							excludingCol.detach();
						}
	
						solve(network, partialSolution);
	
						// add back incident rows and columns
						for (Row excludingRow : excludingRows) {
							excludingRow.attach();
						}						
						for (Col excludingCol : excludingCols) {
							excludingCol.attach();
						}
						
						partialSolution.excludeRow();
					}
				}
			}
		} else {
			partialSolution.declareConcrete();
		}
	}

	/**
	 * Heuristically choose some column.
	 * 
	 * @param network
	 *            - the network to choose a column from
	 * @return a column from the network.
	 */
	protected abstract Col chooseCol(final SpecificNetwork network);

	/**
	 * Heuristically enumerate the possible rows incident to a column.
	 * 
	 * @param col
	 *            - the column, which needs to be enumerated
	 * @return incident rows enumeration.
	 */
	protected abstract Iterable<? extends Row> enumerateRows(final Col col);
}
