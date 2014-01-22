package com.comco.exactcover.puzzles.exactcover;

import java.util.Stack;

import com.comco.exactcover.Row;
import com.comco.exactcover.Solution;

public class ExactCoverSolution implements Solution {
	private final ExactCover exactCover;
	private final Stack<ExactCoverSet> rows = new Stack<>();
	
	public ExactCoverSolution(ExactCover exactCover) {
		this.exactCover = exactCover;
	}
	
	@Override
	public void includeRow(Row row) {
		System.out.println("+ " + row.row());
		rows.add(exactCover.getSet(row.row()));
	}

	@Override
	public void excludeRow() {
		rows.pop();
	}

	@Override
	public void declareConcrete() {
		System.out.println("Solution found:");
		for (ExactCoverSet set : rows) {
			System.out.format("%d ", set.row);
		}
		System.out.println();
	}
}
