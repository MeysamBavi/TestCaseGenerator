public interface ProblemConfigData {

    int getNumberOfTestCases();

    /**The directory to save the test case input files.*/
    String getInputsDirectory();

    /**The directory to save the test case output files (correct answer).*/
    String getOutputsDirectory();

    /**Generates the name of the input file. Index is the number of the test case, starting from 0.*/
    default String generateInputFileName(int index) {
        return "input" + (index + 1) + ".txt";
    }

    /**Generates the name of the output file. Index is the number of the test case, starting from 0.*/
    default String generateOutputFileName(int index) {
        return "output" + (index + 1) + ".txt";
    }

    /**Generates an input for the test case. Index is the number of the test case, starting from 0.*/
    String generateInput(int index);

    /**The directory that console commands are executed in.*/
    String getWorkingDirectory();

    /**This method returns the command that will be given to console to run the solution app.
     example: cd "C:\\src" && java Solution
     The string returned from generateInput will be given to the solution app and the result will be saved in a corresponding output file.*/
    String getSolutionRunCommand(int index);
}
