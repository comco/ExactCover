package com.comco.exactcover.dancinglinks;

public class NaiveDancingLinks extends AbstractDancingLinks {
	public NaiveDancingLinks(ColumnNode head) {
		super(head);
	}

	@Override
	public ColumnNode selectColumn() {
		return head.right;
	}
}
