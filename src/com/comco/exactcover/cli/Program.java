package com.comco.exactcover.cli;

import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.comco.exactcover.gui.MainFrame;

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
			String p = cmd.getOptionValue('p');
			if (p != null) {
				state.puzzleType = PuzzleType.getType(p);
				state.algorithmType = AlgorithmType.getType(cmd
						.getOptionValue('a'));
				if (cmd.hasOption('n')) {
					state.generateNetwork = true;
				}
				state.build();

				if (cmd.hasOption('g')) {
					buildGui(state);
				} else {
					state.solve();
				}
			}
		} catch (ParseException e) {
			LOGGER.severe("cannot parse command line: " + e.getMessage());
		}

	}

	private static Options buildOptions() {
		Option help = new Option("h", "help", false, "help");
		Option puzzle = new Option("p", "puzzle", true,
				"puzzle: cover, polymino, queens, sudoku");
		Option algorithm = new Option("a", "algorithm", true,
				"algorithm: naive, basic, min_column, degree");
		Option gui = new Option("g", "gui", false, "start a gui");
		Option network = new Option("n", "network", false, "save an image of the network");
		
		Options options = new Options();
		options.addOption(help);
		options.addOption(puzzle);
		options.addOption(algorithm);
		options.addOption(gui);
		options.addOption(network);
		return options;
	}

	private static void displayHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar ExactCover.jar", OPTIONS);
	}

	private static void buildGui(final ProgramState state) {
		MainFrame frame = new MainFrame(state);
		frame.setVisible(true);
	}
}
