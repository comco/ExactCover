package com.comco.exactcover;

public interface Col {
	void attach();
	void detach();
	Iterable<? extends Row> incidentRows();
}
