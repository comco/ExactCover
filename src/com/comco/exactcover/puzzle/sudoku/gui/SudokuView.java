package com.comco.exactcover.puzzle.sudoku.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.comco.exactcover.gui.MainFrame;
import com.comco.exactcover.puzzle.sudoku.SudokuPart;

public class SudokuView extends JPanel {
	private static final long serialVersionUID = 1L;

	private final SudokuPiece[][] pieces = new SudokuPiece[9][9];

	public SudokuView(MainFrame frame, final SudokuModel model) {
		super(new GridBagLayout());
		frame.setSize(800, 800);
		GridBagConstraints c = new GridBagConstraints();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				pieces[i][j] = new SudokuPiece(model, i, j);
				c.weightx = 1.0;
				c.weighty = 1.0;
				c.fill = GridBagConstraints.BOTH;
				c.gridx = j;
				c.gridy = i;
				add(pieces[i][j], c);
			}
		}
	}
}

class SudokuPiece extends JLabel implements Observer, EventListener {
	private static final long serialVersionUID = 1L;
	private final SudokuModel model;
	private final int row, col;

	public SudokuPiece(final SudokuModel model, final int row, final int col) {
		this.model = model;
		model.addObserver(this);
		update(null, null);
		this.row = row;
		this.col = col;
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setPreferredSize(new Dimension(32, 32));
		setFont(new Font("Calibri", Font.BOLD, 32));
		setForeground(Color.BLACK);
		setOpaque(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int digit = model.getDigitAt(row, col);
		SudokuPart constraint = model.getCurrentConstraint();
		if (constraint != null && constraint.getRow() == row
				&& constraint.getCol() == col) {
			setBackground(Color.GREEN);
		} else {
			SudokuPart popped = model.getPopped();
			if (popped != null && popped.getRow() == row
					&& popped.getCol() == col) {
				setBackground(Color.RED);
			} else {
				setBackground(Color.WHITE);
			}
		}

		setText(digit > 0 ? Integer.toString(digit) : "");
	}
}