package com.comco.exactcover.puzzle.polymino;

import java.io.InputStream;
import java.util.Scanner;

import com.comco.exactcover.puzzle.PuzzleReader;
import com.comco.exactcover.utils.MaskUtils;

public class PolyminoReader implements PuzzleReader {
	@Override
	public Polymino read(final InputStream input) {
		// read the rows & cols of the board, then the number of pieces
		try (Scanner sc = new Scanner(input)) {
			// read board
			int boardRows = sc.nextInt();
			int boardCols = sc.nextInt();
			int pieces = sc.nextInt();
			boolean[][] board = new boolean[boardRows][boardCols];
			for (int row = 0; row < boardRows; ++row) {
				for (int col = 0; col < boardCols; ++col) {
					int occupied = sc.nextInt();
					board[row][col] = (occupied != 0);
				}
			}
			Polymino polymino = new Polymino(board);

			// read pieces
			for (int i = 0; i < pieces; ++i) {
				int pieceRows = sc.nextInt();
				int pieceCols = sc.nextInt();
				boolean canRotate = sc.nextBoolean();
				boolean canFlip = sc.nextBoolean();
				boolean[][] pieceMask = new boolean[pieceRows][pieceCols];
				for (int row = 0; row < pieceRows; ++row) {
					for (int col = 0; col < pieceCols; ++col) {
						int occupied = sc.nextInt();
						pieceMask[row][col] = (occupied != 0);
					}
				}
				Piece piece = new Piece(polymino,
						MaskUtils.maskClip(pieceMask), canRotate, canFlip);
				polymino.addPiece(piece);
			}
			return polymino;
		}
	}
}
