package com.comco.exactcover.cli;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;

import com.comco.exactcover.Algorithm;
import com.comco.exactcover.SolutionSet;
import com.comco.exactcover.algorithm.GraphvizDrawer;
import com.comco.exactcover.puzzle.Puzzle;

public class ProgramState {
	InputStream input;
	PuzzleType puzzleType;
	AlgorithmType algorithmType;

	public boolean generateNetwork = false;
	public Puzzle puzzle;
	public SolutionSet solutionSet;
	public Algorithm algorithm;
	public boolean quiet;
	
	public ProgramState() {
	}

	public void build() {
		puzzle = PuzzleFactory.INSTANCE.getPuzzleReader(puzzleType).read(input);
		solutionSet = PuzzleFactory.INSTANCE.getSolutionSet(this, puzzleType, puzzle);
		algorithm = AlgorithmFactory.INSTANCE.get(algorithmType, puzzle);
	}

	public void solve() {
		if (generateNetwork) {
			generateNetworkToFile("C:/Users/comco/network.dot");
		}
		algorithm.solve(solutionSet);
		System.out.println("Done!");
		System.out.format("Total number of solutions found: %d\n",
				solutionSet.getNumberOfSolutionsFound());
		System.out.format("Total examined nodes: %d\n",
				solutionSet.getExaminedNodes());
		System.out.format("Total examined columns: %d\n",
				solutionSet.getExaminedColumns());
	}

	public void generateNetworkToFile(String filename) {
		try (PrintWriter out = new PrintWriter(filename)) {
			out.write(new GraphvizDrawer().columnsToGraphviz(puzzle.toNetwork()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
