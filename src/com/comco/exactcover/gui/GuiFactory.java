package com.comco.exactcover.gui;

import javax.swing.JPanel;

import com.comco.exactcover.SolutionKnitter;
import com.comco.exactcover.cli.PuzzleType;
import com.comco.exactcover.puzzle.polymino.PolyminoModel;
import com.comco.exactcover.puzzle.polymino.PolyminoSolutionKnitter;
import com.comco.exactcover.puzzle.polymino.PolyminoView;
import com.comco.exactcover.puzzle.queens.QueensModel;
import com.comco.exactcover.puzzle.queens.QueensSolutionKnitter;
import com.comco.exactcover.puzzle.queens.QueensView;
import com.comco.exactcover.puzzle.sudoku.SudokuModel;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionKnitter;
import com.comco.exactcover.puzzle.sudoku.SudokuView;

public final class GuiFactory {
	public static GuiFactory INSTANCE = new GuiFactory();

	public SolutionKnitterModel getModel(PuzzleType type,
			SolutionKnitter solutionSet) {
		if (solutionSet != null) {
			switch (type) {
			case SUDOKU:
				return new SudokuModel((SudokuSolutionKnitter) solutionSet);
			case POLYMINO:
				return new PolyminoModel((PolyminoSolutionKnitter) solutionSet);
			case QUEENS:
				return new QueensModel((QueensSolutionKnitter) solutionSet);
			default:
				throw new UnsupportedOperationException("Puzzle type " + type
						+ " is not supported for gui.");
			}
		} else {
			throw new IllegalArgumentException(
					"Provided solution set is invalid.");
		}
	}

	public JPanel getView(PuzzleType type, MainFrame frame,
			SolutionKnitterModel model) {
		if (model != null) {
			switch (type) {
			case SUDOKU:
				return new SudokuView(frame, (SudokuModel) model);
			case POLYMINO:
				return new PolyminoView(frame, (PolyminoModel) model);
			case QUEENS:
				return new QueensView(frame, (QueensModel) model);
			default:
				throw new UnsupportedOperationException("Puzzle type " + type
						+ " is not supported for gui.");
			}
		} else {
			throw new IllegalArgumentException("model should be non-null.");
		}
	}
}
