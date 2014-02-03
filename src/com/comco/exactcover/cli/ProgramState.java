package com.comco.exactcover.cli;

import java.io.InputStream;

import com.comco.exactcover.Algorithm;
import com.comco.exactcover.SolutionSet;
import com.comco.exactcover.puzzle.Puzzle;

public class ProgramState {
	InputStream input;
	PuzzleType puzzleType;
	AlgorithmType algorithmType;

	public Puzzle puzzle;
	public SolutionSet solutionSet;
	public Algorithm algorithm;

	public ProgramState() {
	}

	public void build() {
		puzzle = PuzzleFactory.INSTANCE.getPuzzleReader(puzzleType).read(input);
		solutionSet = PuzzleFactory.INSTANCE.getSolutionSet(puzzleType, puzzle);
		algorithm = AlgorithmFactory.INSTANCE.get(algorithmType, puzzle);
	}

	public void solve() {
		algorithm.solve(solutionSet);
		System.out.println("Done!");
		System.out.format("Total number of solutions found: %d\n",
				solutionSet.getNumberOfSolutionsFound());
		System.out.format("Total examined nodes: %d\n", solutionSet.getExaminedNodes());
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
