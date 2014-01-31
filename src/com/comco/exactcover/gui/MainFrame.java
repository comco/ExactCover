package com.comco.exactcover.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.comco.exactcover.cli.ProgramState;
import com.comco.exactcover.puzzle.sudoku.SudokuSolutionSet;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final ProgramState programState;

	public MainFrame(final ProgramState programState) {
		this.programState = programState;
		setTitle("Exact Cover");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		SudokuModel sudokuModel = new SudokuModel(
				(SudokuSolutionSet) programState.solutionSet);
		programState.solutionSet = sudokuModel;

		mainPanel.add(new SudokuView(sudokuModel));
		mainPanel.add(new SimulationControlView(sudokuModel));

		add(mainPanel);
		setVisible(true);
		programState.solve();
	}

	public ProgramState getProgramState() {
		return programState;
	}
}
