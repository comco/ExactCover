package com.comco.exactcover.cli;

import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

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
		} catch (ParseException e) {
			LOGGER.severe("cannot parse command line.");
		}
		
	}

	private static Options buildOptions() {
		Option help = new Option("h", "help", false, "help");
		
		Options options = new Options();
		options.addOption(help);
		return options;
	}
	
	private static void displayHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar ExactCover.jar", OPTIONS);
	}
}
