package com.comco.exactcover.cli;

import java.io.InputStream;

import com.comco.exactcover.AlgorithmXType;
import com.comco.exactcover.Solution;
import com.comco.exactcover.dancinglinks.DancingLinksAlgorithmX;
import com.comco.exactcover.dancinglinks.DancingLinksCol;
import com.comco.exactcover.dancinglinks.DancingLinksNetwork;
import com.comco.exactcover.dancinglinks.DancingLinksRow;
import com.comco.exactcover.dancinglinks.NetworkBuilder;
import com.comco.exactcover.dancinglinks.Node;
import com.comco.exactcover.puzzles.Puzzle;
import com.comco.exactcover.puzzles.PuzzleType;

public class ProgramState {
	InputStream input;
	PuzzleType puzzleType;
	AlgorithmXType algorithmType;

	Puzzle puzzle;
	DancingLinksAlgorithmX algorithm;

	public ProgramState() {
	}

	public void build() {
		puzzle = PuzzleFactory.getReader(puzzleType).read(input);
		algorithm = AlgorithmFactory.getAlgorithm(algorithmType);
	}

	public void solve() {
		Solution solution = puzzle.createSolution();
		DancingLinksNetwork network = new NetworkBuilder().buildNetwork(puzzle
				.toExactCover());
		
		Node root = network.getRoot();
		for (Node row : new DancingLinksCol(root)) {
			for (Node col : new DancingLinksRow(row)) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		
		algorithm.solve(network, solution);
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

	public AlgorithmXType getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(AlgorithmXType algorithmType) {
		this.algorithmType = algorithmType;
	}
}
