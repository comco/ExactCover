package com.comco.exactcover.gui;

import javax.swing.JPanel;

import com.comco.exactcover.SolutionSet;
import com.comco.exactcover.cli.PuzzleType;
import com.comco.exactcover.gui.polymino.PolyminoModel;
import com.comco.exactcover.gui.polymino.PolyminoView;
import com.comco.exactcover.gui.sudoku.SudokuModel;
import com.comco.exactcover.gui.sudoku.SudokuView;
import com.comco.exactcover.puzzle.polymino.PolyminoSolutionSet;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionSet;

public final class GuiFactory {
	public static GuiFactory INSTANCE = new GuiFactory();

	public SolutionSetModel getModel(PuzzleType type, SolutionSet solutionSet) {
		if (solutionSet != null) {
			switch (type) {
			case SUDOKU:
				return new SudokuModel((SudokuSolutionSet) solutionSet);
			case POLYMINO:
				return new PolyminoModel((PolyminoSolutionSet) solutionSet);
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
			SolutionSetModel model) {
		if (model != null) {
			switch (type) {
			case SUDOKU:
				return new SudokuView(frame, (SudokuModel) model);
			case POLYMINO:
				return new PolyminoView(frame, (PolyminoModel) model);
			default:
				throw new UnsupportedOperationException("Puzzle type " + type
						+ " is not supported for gui.");
			}
		} else {
			throw new IllegalArgumentException("model should be non-null.");
		}
	}
}