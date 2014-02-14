package com.comco.exactcover.gui;

import java.util.Observable;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.comco.exactcover.Col;
import com.comco.exactcover.Row;
import com.comco.exactcover.SolutionKnitter;

public class SolutionSetModel extends Observable implements SolutionKnitter {
	private final SolutionKnitter base;

	private int maxNumberOfSolutions = Integer.MAX_VALUE;
	private int rowSleepTime = 20;
	private int solutionSleepTime = 500;

	public SpinnerModel getRowSleepTimeModel() {
		return new SpinnerNumberModel(rowSleepTime, 0, 5000, 100) {
			private static final long serialVersionUID = 1L;

			@Override
			public Integer getNumber() {
				return rowSleepTime;
			}

			@Override
			public void setValue(Object value) {
				super.setValue(value);
				rowSleepTime = (Integer) value;
			}
		};
	}

	public SpinnerModel getSolutionSleepTimeModel() {
		return new SpinnerNumberModel(solutionSleepTime, 0, 5000, 100) {
			private static final long serialVersionUID = 1L;

			@Override
			public Number getNumber() {
				return solutionSleepTime;
			}

			@Override
			public void setValue(Object value) {
				super.setValue(value);
				solutionSleepTime = (Integer) value;
			}

		};
	}

	public SpinnerModel getMaxNumberOfSolutionsModel() {
		return new SpinnerNumberModel(maxNumberOfSolutions, 0,
				Integer.MAX_VALUE, 1) {
			private static final long serialVersionUID = 1L;

			@Override
			public Integer getNumber() {
				return maxNumberOfSolutions;
			}

			@Override
			public void setValue(Object value) {
				super.setValue(value);
				maxNumberOfSolutions = (Integer) value;
			}
		};
	}

	public SolutionSetModel(final SolutionKnitter base) {
		this.base = base;
	}

	public void setMaxNumberOfSolutions(final int maxNumberOfSolutions) {
		this.maxNumberOfSolutions = maxNumberOfSolutions;
	}

	public void setRowSleepTime(final int rowSleepTime) {
		this.rowSleepTime = rowSleepTime;
	}

	public void setSolutionSleepTime(final int solutionSleepTime) {
		this.solutionSleepTime = solutionSleepTime;
	}

	@Override
	public void addRow(final Row row) {
		base.addRow(row);
		setChanged();
		notifyObservers();
		sleep(rowSleepTime);
	}

	@Override
	public void popRow() {
		base.popRow();
		setChanged();
		notifyObservers();
		sleep(rowSleepTime);
	}

	@Override
	public void complete() {
		base.complete();
		setChanged();
		notifyObservers();
		sleep(solutionSleepTime);
	}

	@Override
	public boolean shouldContinue() {
		return foundSolutionsCount() < maxNumberOfSolutions;
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCol(Col col) {
		base.addCol(col);
	}

	@Override
	public void popCol() {
		base.popCol();
	}

	@Override
	public int addedRowsCount() {
		return base.addedRowsCount();
	}

	@Override
	public int addedColsCount() {
		return base.addedColsCount();
	}

	@Override
	public int foundSolutionsCount() {
		return base.foundSolutionsCount();
	}
}
