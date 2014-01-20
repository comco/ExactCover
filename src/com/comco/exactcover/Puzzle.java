package com.comco.exactcover;

/**
 * Represents a puzzle that can be turned into an exact cover problem, with a
 * possible partial resolution (consisting of some "marks" to rows and columns).
 * 
 * @author comco
 * 
 */
public interface Puzzle {
    /**
     * Convert an instance of this puzzle to an exact cover problem.
     * 
     * @return
     */
    boolean[][] toExactCover();

    /**
     * Clears the marks associated with this puzzle.
     */
    void clearMarks();

    /**
     * Marks a row.
     * @param row
     */
    void markRow(final int row);

    /**
     * Unmarks a row.
     * @param row
     */
    void unmarkRow(final int row);

    /**
     * Marks a column.
     * @param col
     */
    void markCol(final int col);

    /**
     * Unmarks a column.
     * @param col
     */
    void unmarkCol(final int col);
}
