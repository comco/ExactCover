package com.comco.exactcover.dancinglinks;


public class BasicDancingLinks extends AbstractDancingLinks {
	public BasicDancingLinks(final ColumnNode head) {
		super(head);
	}

	@Override
	protected ColumnNode selectColumn() {
		for (ColumnNode node = head.right; node != head; node = node.right) {
			if (node.size <= 1) {
				return node;
			}
		}
		return head.right;
	}
}
