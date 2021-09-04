import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        System.out.println("isWindows: " + isWindows);
        TestCaseGenerator generator = new TestCaseGenerator(isWindows, new MyProblem());

        generator.generate();
    }
}
