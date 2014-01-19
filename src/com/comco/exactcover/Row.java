package com.comco.exactcover;

public interface Row {
	void attach();
	void detach();
	Iterable<? extends Col> incidentCols();
}
