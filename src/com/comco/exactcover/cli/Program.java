package com.comco.exactcover.cli;

import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.comco.exactcover.AlgorithmXType;
import com.comco.exactcover.puzzles.PuzzleType;

public class Program {
	private static final Logger LOGGER = Logger.getLogger("Program");
	private static final Options OPTIONS = buildOptions();
	
	public static void main(String[] args) {
		CommandLineParser parser = new GnuParser();
		
		try {
			CommandLine cmd = parser.parse(OPTIONS, args);
			
			if (cmd.hasOption('h')) {
				displayHelp();
			}
			
			ProgramState state = new ProgramState();
			state.input = System.in;
			state.puzzleType = PuzzleType.getType(cmd.getOptionValue('p'));
			state.algorithmType = AlgorithmXType.getType(cmd.getOptionValue('a'));
			state.build();
			
			state.solve();
		} catch (ParseException e) {
			LOGGER.severe("cannot parse command line.");
		}
		
	}

	private static Options buildOptions() {
		Option help = new Option("h", "help", false, "help");
		Option puzzle = new Option("p", "puzzle", true, "puzzle");
		Option algorithm = new Option("a", "algorithm", true, "algorithm");
		
		Options options = new Options();
		options.addOption(help);
		options.addOption(puzzle);
		options.addOption(algorithm);
		return options;
	}
	
	private static void displayHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar ExactCover.jar", OPTIONS);
	}
}
