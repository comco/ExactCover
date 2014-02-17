package com.comco.exactcover.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class SimulationControlView extends JPanel {
	private static final long serialVersionUID = 1L;

	public SimulationControlView(final SolutionKnitterModel model) {
		super();
		addLabeledSpinner("row sleep time: ", model.getRowSleepTimeModel());
		addLabeledSpinner("solution sleep time: ",
				model.getSolutionSleepTimeModel());
		addLabeledSpinner("how many solutions to look for: ",
				model.getMaxNumberOfSolutionsModel());
	}

	private JSpinner addLabeledSpinner(String label, SpinnerModel model) {
		JLabel l = new JLabel(label);
		add(l);
		JSpinner spinner = new JSpinner(model);
		l.setLabelFor(spinner);
		add(spinner);
		return spinner;
	}
}
