package c_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        var start = System.currentTimeMillis();
        for (int testNum = 1; testNum <= 20; testNum++) {
            var testNumStr = String.format("%02d", testNum);
            var pathTest = "go-contest/contest_2023_1/c_problem/tests/";
            var inputFilePath = Paths.get(pathTest + testNumStr);
            var outputFilePath = Paths.get(pathTest + testNumStr + ".a");

            var result = runTest(inputFilePath);
            var expectedResult = Files.readString(outputFilePath);
            var testStatus = result.equals(expectedResult);

            System.out.println(String.format("TEST %d; RESULT: %s", testNum, testStatus));
        }
        System.out.println(String.format("TIME: %d ms", System.currentTimeMillis() - start));
    }

    private static String runTest(Path path) {
        var sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            var inputCount = Integer.valueOf(br.readLine());
            for (int i = 0; i < inputCount; i++) {
                var input = br.readLine();
                var output = checkAutoNumber(input);
                sb.append(output);
                if (i < inputCount-1) {
                    sb.append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public static String checkAutoNumber(String str) {
        var result = "-";
        var regexp = "(\\D{1}\\d{1,2}\\D{2})";
        if (str.replaceAll(regexp, "").length() == 0) {
            result = str.replaceAll(regexp, " $1").trim();
        }
        return result;
    }
}
