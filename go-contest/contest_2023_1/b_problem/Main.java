import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int testNum = 1; testNum <= 15; testNum++) {
            var pathTest = "go-contest/contest_2023_1/b_problem/tests/";
            var inputFilePath = Paths.get(pathTest + testNum);
            var outputFilePath = Paths.get(pathTest + testNum + ".a");

            var result = runTest(inputFilePath);
            var expectedResult = Files.readString(outputFilePath);
            var testStatus = result.equals(expectedResult);

            System.out.println(String.format("TEST %d; RESULT: %s", testNum, testStatus));
        }
    }

    private static String runTest(Path path) {
        var sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            var inputCount = Integer.valueOf(br.readLine());
            for (int i = 0; i < inputCount; i++) {
                var input = br.readLine();
                var output = isShipCorrect(input);
                sb.append(output);
                if (i < inputCount-1) {
                    sb.append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return sb.toString();
    }

    public static String isShipCorrect(String str) {
        int[] shipMap = new int[]{0,0,0,0,0};

        var arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            shipMap[Integer.valueOf(arr[i])]++;
        }

        var result = shipMap[1] == 4 && shipMap[2] == 3 && shipMap[3] == 2 && shipMap[4] == 1;

        return result ? "YES" : "NO";
    }
}
