package com.comco.exactcover.dancinglinks;


/**
 * Class that builds a Dancing Link network from a boolean matrix representation
 * of the Exact Cover problem.
 * 
 * @author comco
 * 
 */
public class NetworkBuilder {
	public DancingLinksNetwork buildNetwork(boolean[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		Node root = createNode(0, 0);
		Node[] hooks = new Node[cols + 1];
		hooks[0] = root;

		for (int j = 1; j <= cols; ++j) {
			hooks[j] = createNode(0, j);
			hooks[j - 1].insertRight(hooks[j]);
		}

		for (int i = 1; i <= rows; ++i) {
			Node current = createNode(i, 0);
			hooks[0].insertTop(current);
			hooks[0] = current;
			for (int j = 1; j <= cols; ++j) {
				if (matrix[i - 1][j - 1]) {
					Node next = createNode(i, j);
					current.insertRight(next);
					current = next;

					hooks[j].insertTop(next);
					hooks[j] = next;
				}
			}
		}

		return createNetwork(root);
	}

	protected DancingLinksNetwork createNetwork(final Node root) {
		return new DancingLinksNetwork(root);
	}

	protected Node createNode(final int row, final int col) {
		return new Node(row, col);
	}
}
