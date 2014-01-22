package com.comco.exactcover.dancinglinks;

import com.comco.exactcover.AlgorithmX;
import com.comco.exactcover.Col;
import com.comco.exactcover.Row;
import com.comco.exactcover.Solution;

/**
 * Default dancing links implementation without any heuristics.
 * 
 * @author comco
 * 
 */
public class DancingLinksAlgorithmX extends AlgorithmX<DancingLinksNetwork> {

	@Override
	public void solve(final DancingLinksNetwork network,
			final Solution partialSolution) {
		if (network.hasCols()) {
			Node column = network.getRoot().getRight();
		} else {
			partialSolution.declareConcrete();
		}
	}
	
	void cover(Node column) {
		// Remove the column from the column list
		for (Node row = column.getTop(); row != column; row = row.getTop()) {
			for (Node at = row.getRight(); at != row; at = at.getRight()) {
				// exclude at from its column
				at.detachBottomTop();
			}
		}
	}
	
	void uncover(Node column) {
		for (Node row = column.getTop(); row != column; row = row.getTop()) {
			for (Node at = row.getRight(); at != row; at = at.getRight()) {
				at.attachBottomTop();
			}
		}
	}

	@Override
	protected DancingLinksCol chooseCol(final DancingLinksNetwork network) {
		return new DancingLinksCol(network.getRoot().getRight());
	}

	@Override
	protected Iterable<? extends Row> enumerateRows(final Col col) {
		return col.incidentRows();
	}
}
