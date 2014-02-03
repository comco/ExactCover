package com.comco.exactcover.algorithm;

import com.comco.exactcover.Algorithm;
import com.comco.exactcover.SolutionSet;

public class BasicDancingLinks implements Algorithm {
	protected final ColumnNode head;

	public BasicDancingLinks(final ColumnNode head) {
		this.head = head;
	}

	@Override
	public void solve(final SolutionSet solutionSet) {
		// System.out.println(head.dumpHead());
		if (head.isUnit()) {
			solutionSet.complete();
		} else if (solutionSet.shouldContinue()) {
			final ColumnNode column = selectColumn();
			if (column.size == 0) {
				return;
			}
			solutionSet.addColumn(column);
			cover(column);
			for (Node rowNode = column.base.top; rowNode != column.base; rowNode = rowNode.top) {
				solutionSet.addRow(rowNode.row);
				for (Node node = rowNode.right; node != rowNode; node = node.right) {
					cover(node.column);
				}

				solve(solutionSet);

				for (Node node = rowNode.left; node != rowNode; node = node.left) {
					uncover(node.column);
				}
				solutionSet.popRow();
			}
			uncover(column);
			solutionSet.popColumn();
		}
	}

	protected ColumnNode selectColumn() {
		for (ColumnNode node = head.right; node != head; node = node.right) {
			if (node.size <= 1) {
				return node;
			}
		}
		return head.right;
	}

	private final void cover(final ColumnNode column) {
		column.detach();
		for (Node rowNode = column.base.top; rowNode != column.base; rowNode = rowNode.top) {
			for (Node node = rowNode.right; node != rowNode; node = node.right) {
				node.detach();
			}
		}
	}

	private final void uncover(final ColumnNode column) {
		for (Node rowNode = column.base.bottom; rowNode != column.base; rowNode = rowNode.bottom) {
			for (Node node = rowNode.left; node != rowNode; node = node.left) {
				node.attach();
			}
		}
		column.attach();
	}
}
