package com.comco.exactcover;

public abstract class AlgorithmX {
	
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
						for (final Row excludingRow : excludingCol.incidentRows()) {
							excludingRow.detach();
						}
						excludingCol.detach();
					}
					
					solve(network, partialSolution);
					
					// add back incident rows and columns
					for (final Col excludingCol : row.incidentCols()) {
						excludingCol.attach();
						for (final Row excludingRow : excludingCol.incidentRows()) {
							excludingRow.attach();
						}
					}
					partialSolution.excludeRow(row);
				}
			}
		} else {
			partialSolution.declareConcrete();
		}
	}
	
	protected abstract Col chooseCol(final Network network);
	protected abstract Iterable<Row> enumerateRows(final Col col);
}
