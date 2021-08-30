import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestCaseGenerator {

    public void generate() throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder().directory(new File(Configuration.workingDirectory));

        Path inputsPath = Path.of(Configuration.inputsDirectory).toAbsolutePath();
        Path outputsPath = Path.of(Configuration.outputsDirectory).toAbsolutePath();

        // creating directories if they don't exist
        new File(inputsPath.toString()).mkdir();
        new File(outputsPath.toString()).mkdir();

        for (int i = 0; i < Configuration.numberOfTestCases; i++) {

            Path inputPath = Path.of(inputsPath.toString(), Configuration.generateInputFileName(i));
            Path outputPath = Path.of(outputsPath.toString(), Configuration.generateOutputFileName(i));

            String input = Configuration.generateInput(i);
            Files.writeString(inputPath, input);

            String command = Configuration.getSolutionRunCommand(i) + " echo > " + outputPath.toAbsolutePath();
            Process process = builder.command("cmd.exe", "/c", command).start();

            PrintStream ops = new PrintStream(process.getOutputStream());
            ops.println(input);
            ops.flush();
            ops.close();

            process.waitFor();

            System.out.print(i + "-");
        }
        System.out.println();
    }
}
