package com.comco.exactcover.algorithm;

public class NaiveDancingLinks extends BasicDancingLinks {
	public NaiveDancingLinks(ColumnNode head) {
		super(head);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ColumnNode selectColumn() {
		return head.right;
	}
}
