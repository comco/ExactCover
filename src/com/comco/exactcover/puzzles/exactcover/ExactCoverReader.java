package com.comco.exactcover.puzzles.exactcover;

import java.io.InputStream;
import java.util.Scanner;

import com.comco.exactcover.puzzle.PuzzleReader;

public class ExactCoverReader implements PuzzleReader {
	@Override
	public ExactCover read(InputStream input) {
		try (Scanner sc = new Scanner(input)) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			boolean[][] matrix = new boolean[rows][cols];
			for (int row = 0; row < rows; ++row) {
				for (int col = 0; col < cols; ++col) {
					int has = sc.nextInt();
					if (has == 1) {
						matrix[row][col] = true;
					}
				}
			}
			return new ExactCover(matrix);
		}
	}
}
