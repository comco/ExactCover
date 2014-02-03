package com.comco.exactcover.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.comco.exactcover.cli.ProgramState;

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

		SolutionSetModel model = GuiFactory.INSTANCE.getModel(
				programState.getPuzzleType(), programState.solutionSet);
		programState.solutionSet = model;

		JPanel view = GuiFactory.INSTANCE.getView(programState.getPuzzleType(),
				model);

		mainPanel.add(view);
		mainPanel.add(new SimulationControlView(model));

		add(mainPanel);
		setVisible(true);
		programState.solve();
	}

	public ProgramState getProgramState() {
		return programState;
	}
}
