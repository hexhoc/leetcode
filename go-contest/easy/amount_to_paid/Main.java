import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int testNum = 1; testNum <= 10; testNum++) {
            var testNumStr = String.format("%02d", testNum);
            var pathTest = "./tests/";
            var inputFilePath = Paths.get(pathTest + testNumStr);
            var outputFilePath = Paths.get(pathTest + testNumStr + ".a");

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
                br.readLine();
                var products = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf).toArray();
                var output = amountToPaid(products);
                sb.append(output).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return sb.toString();
    }

    public static Integer amountToPaid(int[] arr) {
        var m = new HashMap<Integer, Integer>();
        for (int product : arr) {
            if (m.containsKey(product)) {
                m.put(product, m.get(product)+1);
            } else {
                m.put(product, 1);
            }
        }

        var totalSum = 0;
        for (var entry : m.entrySet()) {
            var productCount = entry.getValue() - (entry.getValue() / 3);
            var sum = productCount * entry.getKey();
            totalSum += sum;
        }

        return totalSum;
    }
}
