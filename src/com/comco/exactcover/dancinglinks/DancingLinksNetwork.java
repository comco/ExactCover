package com.comco.exactcover.dancinglinks;

import com.comco.exactcover.Network;

/**
 * A Dancing Link representation for the Exact Cover problem.
 * 
 * @author comco
 * 
 */
public class DancingLinksNetwork implements Network {
	private final Node root;

	public DancingLinksNetwork(final Node root) {
		if (root.getRow() == 0 && root.getCol() == 0) {
			this.root = root;
		} else {
			throw new IllegalArgumentException(
					"The root of a dencing link network should be located at (0, 0).");
		}
	}

	@Override
	public boolean hasRows() {
		return root != root.getTop();
	}

	@Override
	public boolean hasCols() {
		return root != root.getRight();
	}
}
