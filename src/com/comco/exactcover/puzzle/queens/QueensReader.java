package com.comco.exactcover.puzzle.queens;

import java.io.InputStream;
import java.util.Scanner;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleReader;

public class QueensReader implements PuzzleReader {

	@Override
	public Puzzle read(InputStream in) {
		try (Scanner sc = new Scanner(in)) {
			int size = sc.nextInt();
			return new Queens(size);
		}
	}

}
