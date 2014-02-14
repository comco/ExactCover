package com.comco.exactcover.dancinglinks;

import com.comco.exactcover.Problem;
import com.comco.exactcover.SolutionKnitter;

public abstract class AbstractDancingLinks implements Problem {
	protected final ColumnNode head;

	public AbstractDancingLinks(final ColumnNode head) {
		this.head = head;
	}

	@Override
	public void solve(final SolutionKnitter solutionSet) {
		if (head.isUnit()) {
			solutionSet.complete();
		} else if (solutionSet.shouldContinue()) {
			final ColumnNode columnNode = selectColumn();
			if (columnNode.size == 0) {
				return;
			}
			solutionSet.addCol(columnNode.column);
			cover(columnNode);
			for (Node rowNode = columnNode.base.top; rowNode != columnNode.base; rowNode = rowNode.top) {
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
			uncover(columnNode);
			solutionSet.popCol();
		}
	}

	protected abstract ColumnNode selectColumn();

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
