import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestCaseGenerator {

    private final boolean isWindows;

    public TestCaseGenerator(boolean isWindows) {
        this.isWindows = isWindows;
    }

    public void generate() throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder().directory(new File(ProblemConfigData.workingDirectory));

        Path inputsPath = Path.of(ProblemConfigData.inputsDirectory).toAbsolutePath();
        Path outputsPath = Path.of(ProblemConfigData.outputsDirectory).toAbsolutePath();

        // creating directories if they don't exist
        new File(inputsPath.toString()).mkdir();
        new File(outputsPath.toString()).mkdir();

        for (int i = 0; i < ProblemConfigData.numberOfTestCases; i++) {

            Path inputPath = Path.of(inputsPath.toString(), ProblemConfigData.generateInputFileName(i));
            Path outputPath = Path.of(outputsPath.toString(), ProblemConfigData.generateOutputFileName(i));

            String input = ProblemConfigData.generateInput(i);
            Files.writeString(inputPath, input + '\n');


            Process process;
            String command = ProblemConfigData.getSolutionRunCommand(i) + '>' + outputPath.toAbsolutePath();
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
