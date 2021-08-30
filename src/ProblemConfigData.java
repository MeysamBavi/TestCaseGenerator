import java.util.Random;

/**You need to edit this class.*/
abstract public class ProblemConfigData {

    private static final Random RANDOM = new Random();

    public static final int numberOfTestCases = 0;

    /**The directory to save the test case input files.*/
    public static final String inputsDirectory = "";

    /**The directory to save the test case output files (correct answer).*/
    public static final String outputsDirectory = "";

    /**Generates the name of the input file. Index is the number of the test case, starting from 0.*/
    public static String generateInputFileName(int index) {
        return "input" + (index + 1) + ".txt";
    }

    /**Generates the name of the output file. Index is the number of the test case, starting from 0.*/
    public static String generateOutputFileName(int index) {
        return "output" + (index + 1) + ".txt";
    }

    /**Generates an input for the test case. Index is the number of the test case, starting from 0.*/
    public static String generateInput(int index) {
        return null;
    }

    /**The directory that console commands are executed in.*/
    public static final String workingDirectory = "";

    /**This method returns the command that will be given to console to run the solution app.
    example: cd "C:\\src" && java Solution
    The string returned from generateInput will be given to the solution app and the result will be saved in a corresponding output file.*/
    public static String getSolutionRunCommand(int index) {
        return null;
    }
}
