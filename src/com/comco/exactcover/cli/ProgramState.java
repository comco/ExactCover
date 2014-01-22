package com.comco.exactcover.cli;

import com.comco.exactcover.dancinglinks.DancingLinksAlgorithmX;
import com.comco.exactcover.readers.PuzzleReader;

public class ProgramState {
	PuzzleReader reader;
	DancingLinksAlgorithmX algorithm;
	
	public ProgramState(PuzzleReader reader, DancingLinksAlgorithmX algorithm) {
		super();
		this.reader = reader;
		this.algorithm = algorithm;
	}
}
