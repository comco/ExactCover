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
					"The root of a dancing link network should be located at (0, 0).");
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

	public Node getRoot() {
		return root;
	}

	// convert the network to the graphviz format
	public String toGraphVizDot() {
		StringBuilder sb = new StringBuilder();

		sb.append("graph G {\n");
		// Declare nodes
		DancingLinksCol head = new DancingLinksCol(root);
		for (Node headNode : head) {
			DancingLinksRow row = new DancingLinksRow(headNode);
			for (Node node : row) {
				sb.append(String.format("_%d_%d [label=\"\"];\n",
						node.getRow(), node.getCol()));
			}
		}

		// Create links
		for (Node headNode : head) {
			if (headNode.getRow() > 0) {
				for (Node node : new DancingLinksRow(headNode)) {
					if (node.getCol() > 0 && node.getRight().getCol() > 0) {
						Node next = node.getRight();
						sb.append(String.format("_%d_%d -- _%d_%d;\n",
								node.getRow(), node.getCol(), next.getRow(),
								next.getCol()));
					}
				}
			}
		}
		sb.append("}");

		return sb.toString();
	}
}
