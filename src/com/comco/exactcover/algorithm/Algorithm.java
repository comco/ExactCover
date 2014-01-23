package com.comco.exactcover.algorithm;

public class Algorithm {
	public void solve(final ColumnNode head, final SolutionSet solutionSet) {
		//System.out.println(head.dump());
		if (head.isUnit()) {
			solutionSet.complete();
		} else if (solutionSet.shouldContinue()) {
			// select a column
			ColumnNode column = selectColumn(head);
			detachColumnNode(column);
			// enumerate rows
			for (InternalNode rowNode : column.nodesOnColumn()) {
				solutionSet.addRow(rowNode.getRow());
				for (InternalNode node : rowNode.nodesOnRow()) {
					detachColumnNode(node.getColumnNode());
				}
				
				solve(head, solutionSet);
				
				solutionSet.pop();
				for (InternalNode node : rowNode.nodesOnRow()) {
					attachColumnNode(node.getColumnNode());
				}
			}
			attachColumnNode(column);
		}
	}
	
	private void detachColumnNode(final ColumnNode columnNode) {
		columnNode.detachLeftRight();
		for (InternalNode rowNode : columnNode.nodesOnColumn()) {
			for (InternalNode node : rowNode.nodesOnRow()) {
				node.detachBottomTop();
			}
		}
	}
	
	private void attachColumnNode(final ColumnNode columnNode) {
		columnNode.attachLeftRight();
		for (InternalNode rowNode : columnNode.nodesOnColumn()) {
			for (InternalNode node : rowNode.nodesOnRow()) {
				node.attachBottomTop();
			}
		}
	}

	protected ColumnNode selectColumn(ColumnNode head) {
		return head.getRight();
	}
}
