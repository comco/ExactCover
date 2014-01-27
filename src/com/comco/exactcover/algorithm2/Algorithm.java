package com.comco.exactcover.algorithm2;

import java.util.ArrayDeque;

public class Algorithm {
	private final ArrayDeque<Column> columns = new ArrayDeque<>();
	private final ArrayDeque<Node> rowNodes = new ArrayDeque<>();
	
	
	public void solve(final Column head) {
		if (head.isUnit()) {
			complete();
		} else {
			Column column = selectColumn(head);
			cover(column);
			for (Node rowNode = column.base.top; rowNode != column.base; rowNode = rowNode.top) {
				addRow(rowNode.row);
				for (Node node = rowNode.right; node != rowNode; node = node.right) {
					cover(node.column);
				}
				solve(head);
				for (Node node = rowNode.left; node != rowNode; node = node.left) {
					uncover(node.column);
				}
				removeRow();
			}
			uncover(column);
		}
	}

	private void removeRow() {
		// TODO Auto-generated method stub

	}

	private void addRow(Row row) {
		// TODO Auto-generated method stub

	}

	private Column selectColumn(Column head) {
		// TODO Auto-generated method stub
		return null;
	}

	private void complete() {
		// TODO Auto-generated method stub

	}

	private void cover(final Column column) {
		column.detach();
		for (Node rowNode = column.base.top; rowNode != column.base; rowNode = rowNode.top) {
			for (Node node = rowNode.right; node != rowNode; node = node.right) {
				node.detach();
			}
		}
	}

	private void uncover(final Column column) {
		for (Node rowNode = column.base.bottom; rowNode != column.base; rowNode = rowNode.bottom) {
			for (Node node = rowNode.left; node != rowNode; node = node.left) {
				node.attach();
			}
		}
		column.attach();
	}
}
