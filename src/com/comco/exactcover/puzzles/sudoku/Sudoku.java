package com.comco.exactcover.puzzles.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
	private SolutionElement[][][] matrix = new SolutionElement[9][9][9];
	private List<Element> elements = new ArrayList<>();
	private List<Constraint> constraints = new ArrayList<>();
	private int nextElementId = 0;
	private int nextConstraintId = 0;
	
	void addSolutionElement(int row, int col, int val) {
		SolutionElement element = new SolutionElement(this, row, col, val);
		matrix[row][col][val - 1] = element;
		elements.add(element);
	}
	
	public Sudoku() {
		// initialize elements
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				for (int val = 1; val <= 9; ++val) {
					addSolutionElement(row, col, val);
				}
			}
		}
		
		// initialize row constraints
		for (int row = 0; row < 9; ++row) {
			for (int val = 1; val <= 9; ++val) {
				constraints.add(new Row(this, row, val));
			}
		}
		
		// initialize col constraints
		for (int col = 0; col < 9; ++col) {
			for (int val = 1; val <= 9; ++val) {
				constraints.add(new Col(this, col, val));
			}
		}
		
		// initialize pos constraints
		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				constraints.add(new Pos(this, row, col));
			}
		}
		
		// initialize box constraints
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				for (int val = 1; val <= 9; ++val) {
					constraints.add(new Box(this, row, col, val));
				}
			}
		}
	}
	
	public SolutionElement element(int row, int col, int val) {
		return matrix[row][col][val - 1];
	}

	public int nextElementId() {
		return nextElementId++;
	}
	
	public int nextConsraintId() {
		return nextConstraintId++;
	}
	
	public Element newFreshElement() {
		Element element = new Element(this);
		elements.add(element);
		return element;
	}
	
	public void addHint(int row, int col, int val) {
		constraints.add(new Hint(this, row, col, val));
	}
	
	public Element getElementById(int elementId) {
		return elements.get(elementId);
	}
	
	public Constraint getConstraintById(int constraintId) {
		return constraints.get(constraintId);
	}
	
	public boolean[][] toExactCover() {
		boolean[][] result = new boolean[elements.size()][constraints.size()];
		for (Constraint constraint : constraints) {
			for (Element element : constraint.elements()) {
				result[element.id][constraint.id] = true;
			}
		}
		
		return result;
	}
}
