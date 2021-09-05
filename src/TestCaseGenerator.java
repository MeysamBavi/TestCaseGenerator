import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestCaseGenerator {

    private final boolean isWindows;
    private ProblemConfigData problemConfigData;

    public TestCaseGenerator(boolean isWindows, ProblemConfigData problemConfigData) {
        this.isWindows = isWindows;
        this.problemConfigData = problemConfigData;
    }

    public ProblemConfigData getProblemConfigData() {
        return problemConfigData;
    }

    public void setProblemConfigData(ProblemConfigData problemConfigData) {
        this.problemConfigData = problemConfigData;
    }

    public void generate() throws IOException, InterruptedException {

        Path workingDir = Path.of(problemConfigData.getWorkingDirectory());
        ProcessBuilder builder = new ProcessBuilder().directory(workingDir.toFile());

        Path inputsPath = Path.of(problemConfigData.getInputsDirectory());
        inputsPath = workingDir.resolve(inputsPath);

        Path outputsPath = Path.of(problemConfigData.getOutputsDirectory());
        outputsPath = workingDir.resolve(outputsPath);

        // creating directories if they don't exist
        new File(inputsPath.toString()).mkdir();
        new File(outputsPath.toString()).mkdir();

        for (int i = 0; i < problemConfigData.getNumberOfTestCases(); i++) {

            Path inputPath = Path.of(inputsPath.toString(), problemConfigData.generateInputFileName(i));
            Path outputPath = Path.of(outputsPath.toString(), problemConfigData.generateOutputFileName(i));

            String input = problemConfigData.generateInput(i);
            Files.writeString(inputPath, input + '\n');


            Process process;

            String command = problemConfigData.getSolutionRunCommand(i);
            builder.redirectOutput(outputPath.toFile());

            if (isWindows) {
                process = builder.command("cmd", "/c", command).start();
            } else {
                command = '"' + command + '"';
                process = builder.command("sh", "-c", command).start();
            }

            PrintStream ops = new PrintStream(process.getOutputStream());
            ops.println(input);
            ops.flush();
            ops.close();

            process.waitFor();

            System.out.print(i + "-");
        }
        System.out.println("DONE!");
    }
}
