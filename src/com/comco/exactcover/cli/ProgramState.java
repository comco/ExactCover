package com.comco.exactcover.cli;

import java.io.InputStream;

import com.comco.exactcover.algorithm.Algorithm;
import com.comco.exactcover.algorithm.ColumnNode;
import com.comco.exactcover.algorithm.SolutionSet;
import com.comco.exactcover.puzzle.Puzzle;

public class ProgramState {
	InputStream input;
	PuzzleType puzzleType;
	AlgorithmType algorithmType;

	Puzzle puzzle;
	SolutionSet solutionSet;
	Algorithm algorithm;
	
	public ProgramState() {
	}

	public void build() {
		puzzle = PuzzleFactory.INSTANCE.getPuzzleReader(puzzleType).read(input);
		solutionSet = PuzzleFactory.INSTANCE.getSolutionSet(puzzleType, puzzle);
		algorithm = AlgorithmFactory.INSTANCE.get(algorithmType);
	}

	public void solve() {
		ColumnNode head = puzzle.toNetwork();
		algorithm.solve(head, solutionSet);
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public PuzzleType getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(PuzzleType puzzleType) {
		this.puzzleType = puzzleType;
	}

	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(AlgorithmType algorithmType) {
		this.algorithmType = algorithmType;
	}
}
