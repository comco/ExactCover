package com.comco.exactcover.puzzle.sudoku;

import java.io.InputStream;
import java.util.Scanner;

import com.comco.exactcover.puzzle.PuzzleReader;

public class SudokuReader implements PuzzleReader {
	@Override
	public Sudoku read(final InputStream input) {
		try (Scanner sc = new Scanner(input)) {
			Sudoku sudoku = new Sudoku();
			for (int row = 0; row < 9; ++row) {
				for (int col = 0; col < 9; ++col) {
					int val = sc.nextInt();
					if (val != 0) {
						sudoku.addHint(row, col, val);
					}
				}
			}
			return sudoku;
		}
	}
}
