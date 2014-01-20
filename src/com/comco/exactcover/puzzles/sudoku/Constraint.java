package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

public abstract class Constraint {
	private final Sudoku sudoku;
	final int id;
	private final List<Element> elements = new ArrayList<>();
	
	public Constraint(Sudoku sudoku) {
		super();
		this.sudoku = sudoku;
		this.id = sudoku.nextConsraintId();
	}
	
	protected void addElement(final Element element) {
		elements.add(element);
	}
	
	protected void addElement(int row, int col, int val) {
		addElement(sudoku.element(row, col, val));
	}

	public Iterable<Element> elements() {
		return elements;
	}
}
