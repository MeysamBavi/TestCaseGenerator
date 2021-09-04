import java.util.Random;

public class MyProblem implements ProblemConfigData {

    private static final Random RANDOM = new Random();

    @Override
    public int getNumberOfTestCases() {
        return 0;
    }

    @Override
    public String getInputsDirectory() {
        return null;
    }

    @Override
    public String getOutputsDirectory() {
        return null;
    }

    @Override
    public String getWorkingDirectory() {
        return null;
    }

    @Override
    public String getSolutionRunCommand(int index) {
        return null;
    }

    @Override
    public String generateInput(int index) {
        return null;
    }
}
