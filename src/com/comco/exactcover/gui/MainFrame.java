package com.comco.exactcover.gui;

import javax.swing.JFrame;

import com.comco.exactcover.cli.ProgramState;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final ProgramState programState;
	
	public MainFrame(final ProgramState programState) {
		this.programState = programState;
		setTitle("Exact Cover");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ProgramState getProgramState() {
		return programState;
	}
}
