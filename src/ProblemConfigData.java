public interface ProblemConfigData {

    /**The directory that console commands are executed in.
     <br/>
     * {@link #getInputsDirectory() Inputs} and {@link #getOutputsDirectory() Outputs} paths are resolved with (and can be relative to) this directory.
     **/
    String getWorkingDirectory();

    /**The directory to save the test case input files. This path will be resolved with {@link #getWorkingDirectory() working directory}.*/
    String getInputsDirectory();

    /**The directory to save the test case output files (correct answer). This path will be resolved with {@link #getWorkingDirectory() working directory}.*/
    String getOutputsDirectory();

    /**Generates the name of the input file. Index is the number of the test case, starting from 0.*/
    default String generateInputFileName(int index) {
        return "input" + (index + 1) + ".txt";
    }

    /**Generates the name of the output file. Index is the number of the test case, starting from 0.*/
    default String generateOutputFileName(int index) {
        return "output" + (index + 1) + ".txt";
    }

    /** @return Total number of test cases.*/
    int getNumberOfTestCases();

    /**Generates an input for the test case. Index is the number of the test case, starting from 0.*/
    String generateInput(int index);

    /**This method returns the command that will be given to console to run the solution app.
     <br/><br/>
     for example: <pre>python solution.py</pre>
     <br/>
     The string returned from {@link #generateInput(int)} will be given to the solution app and the result will be saved in a corresponding output file.*/
    String getSolutionRunCommand(int index);
}
