package com.comco.exactcover.algorithm;

public class Algorithm {
	void solve(final ColumnNode head, final SolutionSet solutionSet) {
		if (head.isUnit()) {
			solutionSet.complete();
		} else if (solutionSet.shouldContinue()) {
			// select a column
			ColumnNode column = selectColumn(head);
			detachColumn(column);
			// enumerate rows
			for (InternalNode rowNode : column.nodesOnColumn()) {
				solutionSet.addRow(rowNode.getRow());
				for (InternalNode node : rowNode.nodesOnRow()) {
					detachColumn(node.getColumnNode());
				}
				
				solve(head, solutionSet);
				
				solutionSet.pop();
				for (InternalNode node : rowNode.nodesOnRow()) {
					attachColumn(node.getColumnNode());
				}
			}
			attachColumn(column);
		}
	}
	
	private void detachColumn(final ColumnNode column) {
		column.detachLeftRight();
		for (InternalNode row : column.nodesOnColumn()) {
			for (InternalNode node : row.nodesOnRow()) {
				node.detachBottomTop();
			}
		}
	}
	
	private void attachColumn(final ColumnNode column) {
		column.attachLeftRight();
		for (InternalNode row : column.nodesOnColumn()) {
			for (InternalNode node : row.nodesOnRow()) {
				node.attachBottomTop();
			}
		}
	}

	protected ColumnNode selectColumn(ColumnNode head) {
		return head.getRight();
	}
}
