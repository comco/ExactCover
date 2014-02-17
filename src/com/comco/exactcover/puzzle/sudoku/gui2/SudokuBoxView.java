package com.comco.exactcover.puzzle.sudoku.gui2;

import javax.swing.JLabel;

public class SudokuBoxView {
	private final int i, j;
	public Integer value;
	private final boolean[] marks = new boolean[9];
	private final JLabel[] markViews = new JLabel[9];

	public SudokuBoxView(int i, int j) {
		this.i = i;
		this.j = j;

		for (int val = 0; val < 9; ++val) {
			marks[val] = true;

		}
	}

	public void valueAdded(int value) {
		this.value = value;
		redraw();
	}

	public void valueRemoved() {
		this.value = null;
		redraw();
	}

	public void markAdded(int mark) {
		marks[mark] = true;
		redraw();
	}

	public void markRemoved(int mark) {
		marks[mark] = false;
		redraw();
	}

	private void redraw() {

	}
}
