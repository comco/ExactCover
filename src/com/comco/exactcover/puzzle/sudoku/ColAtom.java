package com.comco.exactcover.puzzle.sudoku;

public class ColAtom extends SudokuAtom	{
	private final int col;
	private final int val;
	
	public ColAtom(Sudoku sudoku, int col, int val) {
		super(sudoku);
		this.col = col;
		this.val = val;
		
		for (int row = 0; row < 9; ++row) {
			attach(row, col, val);
		}
	}
	
	public int getCol() {
		return col;
	}
	
	public int getVal() {
		return val;
	}
}
