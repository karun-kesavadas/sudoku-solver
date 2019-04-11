package config;

/**
 * List of constants
 */
public class Constants
{
    //User Configurable Constants
    public static final double ELITISM_RATE = Double.parseDouble(Config.getInstance().getConfig(Properties.ELITISM_RATE).toString());
    public static final double MUTATION_RATE = Double.parseDouble(Config.getInstance().getConfig(Properties.MUTATION_RATE).toString());
    public static final int POPULATION_SIZE = Integer.parseInt(Config.getInstance().getConfig(Properties.POPULATION_SIZE).toString());
    public static final int POPULATIONS_BEFORE_RESTART = Integer.parseInt(Config.getInstance().getConfig(Properties.POPULATIONS_BEFORE_RESTART).toString());
    public static final int NUMBER_OF_PARENTS = Integer.parseInt(Config.getInstance().getConfig(Properties.NUMBER_OF_PARENTS).toString());

    //Constants (Not user configurable)
    public static final int SUDOKU_SIDE_LENGTH = 9;
    public static final int SUDOKU_MIN_VALUE = 1;
    public static final int SUDOKU_MAX_VALUE = 9;
    public static final String SUDOKU_PROBLEM_PATH = "resources/sudoku.txt";
    public static final String CONFIGURATION_FILE_PATH = "resources/config.properties";
}
