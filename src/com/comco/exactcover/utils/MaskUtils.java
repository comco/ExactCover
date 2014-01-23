package com.comco.exactcover.utils;

/**
 * 2D boolean mask utilities.
 * 
 * @author comco
 * 
 */
public final class MaskUtils {
	private MaskUtils() {
	}

	public static int maskRows(final boolean[][] mask) {
		return mask.length;
	}

	public static int maskCols(final boolean[][] mask) {
		return mask[0].length;
	}

	public static boolean[][] maskRotate(final boolean[][] mask) {
		int rows = maskRows(mask);
		int cols = maskCols(mask);
		boolean[][] result = new boolean[cols][rows];
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				result[cols - 1 - col][row] = mask[row][col];
			}
		}
		return result;
	}

	public static boolean[][] maskFlip(final boolean[][] mask) {
		int rows = maskRows(mask);
		int cols = maskCols(mask);
		boolean[][] result = new boolean[rows][cols];
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				result[row][cols - 1 - col] = mask[row][col];
			}
		}
		return result;
	}

	public static boolean[][] maskClip(final boolean[][] mask) {
		int rows = maskRows(mask);
		int cols = maskCols(mask);
		int minRow = 0, maxRow = rows - 1;
		int minCol = 0, maxCol = cols - 1;
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (mask[row][col]) {
					minRow = Math.min(minRow, row);
					maxRow = Math.max(maxRow, row);
					minCol = Math.min(minCol, col);
					maxCol = Math.max(maxCol, col);
				}
			}
		}

		boolean[][] result = new boolean[maxRow + 1 - minRow][maxCol + 1
				- minCol];
		for (int row = minRow; row <= maxRow; ++row) {
			for (int col = minCol; col <= maxCol; ++col) {
				result[row - minRow][col - minCol] = mask[row][col];
			}
		}
		return result;
	}

	public static boolean canPlaceAt(final boolean[][] board, final int row,
			final int col, final boolean[][] piece) {
		int boardRows = maskRows(board);
		int boardCols = maskCols(board);
		int pieceRows = maskRows(piece);
		int pieceCols = maskCols(piece);

		if (row + pieceRows < boardRows && col + pieceCols < boardCols) {
			for (int pieceRow = 0; pieceRow < pieceRows; ++pieceRow) {
				for (int pieceCol = 0; pieceCol < pieceCols; ++pieceCol) {
					if (piece[pieceRow][pieceCol]
							&& board[row + pieceRow][col + pieceCol]) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
