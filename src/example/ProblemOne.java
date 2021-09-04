import java.io.IOException;
import java.util.Random;

public class ProblemOne implements ProblemConfigData {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {

        TestCaseGenerator generator = new TestCaseGenerator(true, new ProblemOne());
        generator.generate();
    }

    @Override
    public int getNumberOfTestCases() {
        return 30;
    }

    @Override
    public String getInputsDirectory() {
        return "C:\\src\\ProblemOne\\in";
    }

    @Override
    public String getOutputsDirectory() {
        return "C:\\src\\ProblemOne\\out";
    }

    @Override
    public String generateInput(int index) {
        return (RANDOM.nextInt(101) - 50) + " " + (RANDOM.nextInt(101) - 50);
    }

    @Override
    public String getWorkingDirectory() {
        return "C:\\src\\ProblemOne";
    }

    //if solution.py is stored in the working directory, you can run it directly
    @Override
    public String getSolutionRunCommand(int index) {
        return "python solution.py";
    }
}
