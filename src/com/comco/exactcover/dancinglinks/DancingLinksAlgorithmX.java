package com.comco.exactcover.dancinglinks;

import com.comco.exactcover.AlgorithmX;

/**
 * Default dancing links implementation without any heuristics.
 * 
 * @author comco
 * 
 */
public class DancingLinksAlgorithmX extends
		AlgorithmX<DancingLinksNetwork, DancingLinksRow, DancingLinksCol> {

	@Override
	protected DancingLinksCol chooseCol(final DancingLinksNetwork network) {
		return new DancingLinksCol(network.getRoot().getRight());
	}

	@Override
	protected Iterable<DancingLinksRow> enumerateRows(final DancingLinksCol col) {
		return col.incidentRows();
	}
}
