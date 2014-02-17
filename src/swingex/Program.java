package swingex;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Program {
	private static final JPanel firstPanel = buildFirstPanel();

	public static JLabel buildJLabel(String name, GridBagConstraints c) {
		JLabel l = new JLabel(name, SwingConstants.CENTER);
		l.setBorder(new LineBorder(Color.BLACK));
		return l;
	}

	public static JPanel buildFirstPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 3));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panel.add(buildJLabel("1", c));
		c.gridx = 1;
		c.gridy = 0;
		panel.add(buildJLabel("1", c));
		c.gridx = 2;
		c.gridy = 0;
		panel.add(buildJLabel("1", c));
		c.gridx = 0;
		c.gridy = 1;
		panel.add(buildJLabel("1", c));
		c.gridx = 1;
		c.gridy = 1;
		panel.add(buildJLabel("1", c));
		c.gridx = 2;
		c.gridy = 1;
		panel.add(buildJLabel("1", c));
		c.gridx = 0;
		c.gridy = 2;
		panel.add(buildJLabel("1", c));
		c.gridx = 1;
		c.gridy = 2;
		panel.add(buildJLabel("1", c));
		c.gridx = 2;
		c.gridy = 2;
		panel.add(buildJLabel("1", c));
		panel.setBackground(Color.CYAN);
		panel.setOpaque(true);
		panel.setPreferredSize(new Dimension(80, 80));
		return panel;
	}

	private static final JPanel secondPanel = buildSecondPanel();

	public static JPanel buildSecondPanel() {
		JPanel panel = new JPanel(new GridLayout());
		JLabel label = new JLabel("4", SwingConstants.CENTER);
		panel.add(label);
		float size = label.getFont().getSize2D();
		Font derivedFont = label.getFont().deriveFont(size * 3.0f);
		label.setFont(derivedFont);
		label.setBorder(new LineBorder(Color.BLACK));
		panel.setPreferredSize(new Dimension(80, 80));
		panel.setBackground(Color.RED);
		panel.setOpaque(true);
		return panel;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Test");
		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel();
		contentPane.add(panel);

		// panel.add(firstPanel);
		panel.add(secondPanel);
		panel.remove(secondPanel);
		panel.add(firstPanel);
		panel.remove(firstPanel);
		panel.add(secondPanel);

		frame.pack();
		frame.setVisible(true);

	}
}
//
// GridBagConstraints c = new GridBagConstraints();
// c.gridx = 0;
// c.gridy = 0;
// panel.add(new JLabel("1"), c);
// c.gridx = 1;
// c.gridy = 0;
// panel.add(new JLabel("2"), c);
// c.gridx = 2;
// c.gridy = 0;
// panel.add(new JLabel("3"), c);
// c.gridx = 0;
// c.gridy = 1;
// panel.add(new JLabel("4"), c);
// c.gridx = 1;
// c.gridy = 1;
// panel.add(new JLabel("5"), c);
// c.gridx = 2;
// c.gridy = 1;
// panel.add(new JLabel("6"), c);
// c.gridx = 0;
// c.gridy = 2;
// panel.add(new JLabel("7"), c);
// c.gridx = 1;
// c.gridy = 2;
// panel.add(new JLabel("8"), c);
// c.gridx = 2;
// c.gridy = 2;
// panel.add(new JLabel("9"), c);
