package com.comco.exactcover.algorithm;

public class Algorithm {
	public void solve(final ColumnNode head, final SolutionSet solutionSet) {
		System.out.println(head.dump());
		if (head.isUnit()) {
			solutionSet.complete();
		} else if (solutionSet.shouldContinue()) {
			// select a column
			ColumnNode column = selectColumn(head);
			cover(column);
			// enumerate rows
			for (InternalNode rowNode : column.nodesOnColumn()) {
				solutionSet.addRow(rowNode.getRow());
				for (InternalNode node : rowNode.nodesOnRow()) {
					cover(node.getColumnNode());
				}
				solve(head, solutionSet);

				solutionSet.pop();
				for (InternalNode node : rowNode.nodesOnRow()) {
					uncover(node.getColumnNode());
				}
			}
			uncover(column);
		}
	}

	private void cover(final ColumnNode columnNode) {
		if (columnNode.getLeft().getRight() == columnNode) {
			columnNode.detachLeftRight();
			for (InternalNode rowNode : columnNode.nodesOnColumn()) {
				for (InternalNode node : rowNode.nodesOnRow()) {
					node.detachBottomTop();
				}
			}
		}
	}

	private void uncover(final ColumnNode columnNode) {
		if (columnNode.getLeft().getRight() != columnNode) {
			columnNode.attachLeftRight();
			for (InternalNode rowNode : columnNode.nodesOnColumn()) {
				for (InternalNode node : rowNode.nodesOnRow()) {
					node.attachBottomTop();
				}
			}
		}
	}

	protected ColumnNode selectColumn(ColumnNode head) {
		return head.getRight();
	}
}
