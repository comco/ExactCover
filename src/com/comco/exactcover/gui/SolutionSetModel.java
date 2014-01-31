package com.comco.exactcover.gui;

import java.util.Observable;

import com.comco.exactcover.Row;
import com.comco.exactcover.SolutionSet;

public class SolutionSetModel extends Observable implements SolutionSet {
	private final SolutionSet base;
	
	private int maxNumberOfSolutions = Integer.MAX_VALUE;
	private int numberOfSolutionsFound = 0;
	private int rowSleepTime = 20;
	private int solutionSleepTime = 500;
	
	public SolutionSetModel(final SolutionSet base) {
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
		++numberOfSolutionsFound;
		setChanged();
		notifyObservers();
		sleep(solutionSleepTime);
	}

	@Override
	public boolean shouldContinue() {
		return numberOfSolutionsFound < maxNumberOfSolutions;
	}
	
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
