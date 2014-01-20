package com.comco.exactcover.puzzles.sudoku;

public class Element {
	final Sudoku sudoku;
	final int id;
	
	public Element(final Sudoku sudoku) {
		this.sudoku = sudoku;
		this.id = sudoku.nextElementId();
	}
}
