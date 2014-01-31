package com.comco.exactcover.gui;

import java.util.Observable;

import com.comco.exactcover.Row;
import com.comco.exactcover.SolutionSet;

public class ObservableSolutionSet extends Observable implements SolutionSet {
	private final SolutionSet base;

	public ObservableSolutionSet(final SolutionSet base) {
		this.base = base;
	}

	@Override
	public void addRow(final Row row) {
		base.addRow(row);
		setChanged();
		notifyObservers();
	}

	@Override
	public void popRow() {
		base.popRow();
		setChanged();
		notifyObservers();
	}

	@Override
	public void complete() {
		base.complete();
		setChanged();
		notifyObservers();
	}

	@Override
	public boolean shouldContinue() {
		return base.shouldContinue();
	}
}
