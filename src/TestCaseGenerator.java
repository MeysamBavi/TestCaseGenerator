import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestCaseGenerator {

    public void generate() throws IOException, InterruptedException {

        Path inputsPath = Paths.get(ProblemInfo.inputsDirectory).toAbsolutePath();
        Path outputPath = Paths.get(ProblemInfo.outputsDirectory).toAbsolutePath();

        for (int i = 0; i < ProblemInfo.numberOfTestCases; i++) {
            File inputFile = new File(
                    inputsPath.toString() +
                            File.separator +
                            ProblemInfo.generateInputFileName(i)
            );
            inputFile.createNewFile();
            File outputFile = new File(
                    outputPath.toString() +
                            File.separator +
                            ProblemInfo.generateOutputFileName(i)
            );
            outputFile.createNewFile();

            String input = ProblemInfo.generateInput(i);
            Files.writeString(inputFile.toPath(), input);

            String command = ProblemInfo.getSolutionRunCommand(i) + " echo > " + outputFile.toPath().toAbsolutePath().toString();

            Process process = new ProcessBuilder("cmd.exe", "/c", command).start();
            PrintStream ops = new PrintStream(process.getOutputStream());
            ops.println(input);
            ops.flush();
            ops.close();

            process.waitFor();
        }
    }
}
