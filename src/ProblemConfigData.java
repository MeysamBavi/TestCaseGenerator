public interface ProblemConfigData {

    /**The directory that console commands are executed in. Also Inputs and Outputs paths are resolved with (can be relative to) working directory.*/
    String getWorkingDirectory();

    /**The directory to save the test case input files. This path will be resolved with working directory.*/
    String getInputsDirectory();

    /**The directory to save the test case output files (correct answer). This path will be resolved with working directory.*/
    String getOutputsDirectory();

    /**Generates the name of the input file. Index is the number of the test case, starting from 0.*/
    default String generateInputFileName(int index) {
        return "input" + (index + 1) + ".txt";
    }

    /**Generates the name of the output file. Index is the number of the test case, starting from 0.*/
    default String generateOutputFileName(int index) {
        return "output" + (index + 1) + ".txt";
    }

    int getNumberOfTestCases();

    /**Generates an input for the test case. Index is the number of the test case, starting from 0.*/
    String generateInput(int index);

    /**This method returns the command that will be given to console to run the solution app.
     for example: python solution.py
     The string returned from generateInput will be given to the solution app and the result will be saved in a corresponding output file.*/
    String getSolutionRunCommand(int index);
}
