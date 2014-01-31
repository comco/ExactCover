package com.comco.exactcover.gui;

import javax.swing.JFrame;

import com.comco.exactcover.cli.ProgramState;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionSet;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final ProgramState programState;

	public MainFrame(final ProgramState programState) {
		this.programState = programState;
		setTitle("Exact Cover");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		SudokuModel sudokuModel = new SudokuModel(
				(SudokuSolutionSet) programState.solutionSet);
		programState.solutionSet = sudokuModel;
		add(new SudokuView(sudokuModel));

		setVisible(true);
		programState.solve();
	}

	public ProgramState getProgramState() {
		return programState;
	}
}
