package com.comco.exactcover.puzzle.queens;

import java.awt.Color;
import java.awt.Dimension;
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

public class QueensView extends JPanel {
	private static final long serialVersionUID = 1L;

	private final QueensPiece[][] pieces;

	public QueensView(MainFrame frame, final QueensModel model) {
		super(new GridBagLayout());
		frame.setSize(800, 800);
		int size = model.getSize();
		GridBagConstraints c = new GridBagConstraints();
		pieces = new QueensPiece[size][size];
		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				pieces[row][col] = new QueensPiece(model, row, col);
				c.weightx = 1.0;
				c.weighty = 1.0;
				c.fill = GridBagConstraints.BOTH;
				c.gridx = col;
				c.gridy = row;
				add(pieces[row][col], c);
			}
		}
	}
}

class QueensPiece extends JLabel implements Observer, EventListener {
	private static final long serialVersionUID = 1L;
	private static final String QUEENS_UNICODE_SYMBOL = "\u2654";
	private final QueensModel model;
	private final int row, col;

	public QueensPiece(final QueensModel model, int row, int col) {
		this.model = model;
		model.addObserver(this);
		update(null, null);
		this.row = row;
		this.col = col;
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setPreferredSize(new Dimension(32, 32));
		setFont(getFont().deriveFont(30f));
		setForeground(Color.BLACK);
		setOpaque(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		boolean hasQueen = model.hasQueenAt(row, col);
		if (hasQueen) {
			setText(QUEENS_UNICODE_SYMBOL);
			setBackground(Color.GREEN);
		} else {
			setText("");
			if (model.canPutQueenAt(row, col)) {
				setBackground(Color.WHITE);
			} else {
				setBackground(Color.RED);
			}
		}
	}

}