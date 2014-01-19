package com.comco.exactcover;

/**
 * Abstract class implementing Knuth's Algorithm X. Generates all solutions.
 * Concrete heuristics can be implemented in subclasses.
 * 
 * @author comco
 * 
 */
public abstract class AlgorithmX {

	/**
	 * Solves an exact cover problem, represented by a network.
	 * 
	 * @param network
	 *            - represents an exact cover problem
	 * @param partialSolution
	 *            - stores the solutions found
	 */
	public void solve(final Network network, final Solution partialSolution) {
		if (network.hasRows()) {
			if (network.hasCols()) {
				// choose a column deterministically
				Col col = chooseCol(network);
				// choose a row non-deterministically
				for (final Row row : enumerateRows(col)) {
					partialSolution.includeRow(row);

					// remove incident rows and columns
					for (final Col excludingCol : row.incidentCols()) {
						for (final Row excludingRow : excludingCol
								.incidentRows()) {
							excludingRow.detach();
						}
						excludingCol.detach();
					}

					solve(network, partialSolution);

					// add back incident rows and columns
					for (final Col excludingCol : row.incidentCols()) {
						excludingCol.attach();
						for (final Row excludingRow : excludingCol
								.incidentRows()) {
							excludingRow.attach();
						}
					}
					partialSolution.excludeRow();
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
	protected abstract Col chooseCol(final Network network);

	/**
	 * Heuristically enumerate the possible rows incident to a column.
	 * 
	 * @param col
	 *            - the column, which needs to be enumerated
	 * @return incident rows enumeration.
	 */
	protected abstract Iterable<Row> enumerateRows(final Col col);
}
