package com.comco.exactcover.puzzle.queens.io;

import java.io.InputStream;
import java.util.Scanner;

import com.comco.exactcover.puzzle.Puzzle;
import com.comco.exactcover.puzzle.PuzzleReader;
import com.comco.exactcover.puzzle.queens.Queens;

public class QueensReader implements PuzzleReader {

	@Override
	public Puzzle read(InputStream in) {
		try (Scanner sc = new Scanner(in)) {
			int size = sc.nextInt();
			return new Queens(size);
		}
	}

}
