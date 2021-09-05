import java.io.IOException;
import java.util.Random;

public class ProblemOne implements ProblemConfigData {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {

        TestCaseGenerator generator = new TestCaseGenerator(true, new ProblemOne());
        generator.generate();
    }

    @Override
    public String getWorkingDirectory() {
        return "/src/ProblemOne";
    }

    //Inputs and Outputs directories can be relative to working directory.
    @Override
    public String getInputsDirectory() {
        return "./in";
    }

    //Inputs and Outputs directories can be relative to working directory.
    @Override
    public String getOutputsDirectory() {
        return "./out";
    }

    @Override
    public int getNumberOfTestCases() {
        return 10;
    }

    @Override
    public String generateInput(int index) {
        return (RANDOM.nextInt(101) - 50) + " " + (RANDOM.nextInt(101) - 50);
    }

    //Because solution.py is in the working directory, we can run it directly
    @Override
    public String getSolutionRunCommand(int index) {
        return "python solution.py";
    }
}
