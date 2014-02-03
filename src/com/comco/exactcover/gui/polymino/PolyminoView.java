package com.comco.exactcover.gui.polymino;

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

public class PolyminoView extends JPanel {
	private static final long serialVersionUID = 1L;

	private final PolyminoCell[][] cells;

	public PolyminoView(final MainFrame frame, final PolyminoModel model) {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int rows = model.getRows();
		int cols = model.getCols();
		frame.setSize(80 * cols, 80 * rows);
		cells = new PolyminoCell[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				cells[i][j] = new PolyminoCell(model, i, j);
				c.weightx = 1.0;
				c.weighty = 1.0;
				c.fill = GridBagConstraints.BOTH;
				c.gridx = j;
				c.gridy = i;
				add(cells[i][j], c);
			}
		}
	}
}

class PolyminoCell extends JLabel implements Observer, EventListener {
	private static final long serialVersionUID = 1L;
	private final PolyminoModel model;
	private final int row, col;

	public PolyminoCell(PolyminoModel model, int row, int col) {
		this.model = model;
		this.row = row;
		this.col = col;
		model.addObserver(this);
		update(null, null);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setPreferredSize(new Dimension(20, 20));
		setOpaque(true);
		setFont(new Font("Calibri", Font.BOLD, 32));
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int pieceId = model.getPieceIdAt(row, col);
		if (pieceId >= 0) {
			Color pieceColor = Color.getHSBColor((1 + ((float) pieceId))
					/ (1 + model.getNumberOfPieces()), 1.0f, 0.8f);
			setBackground(pieceColor);
			setText(Integer.toString(pieceId));
		} else if (pieceId == -1) {
			setBackground(Color.WHITE);
			setText("");
		} else if (pieceId == -2) {
			setBackground(Color.GRAY);
			setText("");
		}
	}
}