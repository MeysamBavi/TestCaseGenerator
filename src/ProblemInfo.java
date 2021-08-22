
// You need to edit this class

abstract public class ProblemInfo {

    public static final int numberOfTestCases = -1;

    // the directory to save the test case input files
    public static final String inputsDirectory = "";

    // the directory to save the test case output files (correct answer)
    public static final String outputsDirectory = "";

    // generates the name of the input file. the index is number of test case, starting from 0.
    public static String generateInputFileName(int index) {
        return "input" + (index + 1) + ".txt";
    }

    // generates the name of the output file. the index is number of test case, starting from 0.
    public static String generateOutputFileName(int index) {
        return "output" + (index + 1) + ".txt";
    }

    // generates an input for the test case. the index is number of test case, starting from 0.
    public static String generateInput(int index) {
        return null;
    }

    // this method gives the command that will be given to console to run the solution app
    // example: cd "C:\\src" && java Solution
    // the string returned from generateInput will be given to the solution app and the result will be saved in the corresponding output file.
    public static String getSolutionRunCommand(int index) {
        return null;
    }
}
