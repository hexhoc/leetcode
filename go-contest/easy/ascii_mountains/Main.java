import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        var start = System.currentTimeMillis();
        for (int testNum = 1; testNum <= 18; testNum++) {
            var testNumStr = String.format("%02d", testNum);
            var pathTest = "./tests/";
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
                var param = br.readLine().split(" ");

                var param1 = Integer.valueOf(param[0]);
                var param2 = Integer.valueOf(param[1]);
                var param3 = Integer.valueOf(param[2]);
                String[][] arr = new String[param1][param2];
                for (int j = 0; j < param1; j++) {
                    String[] mLine = new String[param2];
                    for (int j2 = 0; j2 < param2; j2++) {
                        mLine[j2] = br.readLine();
                    }
                    arr[j] = mLine;
                    if (j < param1-1) {
                        br.readLine();
                    }
                    
                }
                var output = asciiMountain(param2, param3, arr);
                sb.append(output).append("\r\n");
                if (i < inputCount-1) {
                    sb.append("\r\n");
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        sb.append("\r\n");
        return sb.toString();
    }

    public static String asciiMountain(Integer height, Integer width, String[][] mountains) {
        var main = mountains[mountains.length-1];
        for (int i = mountains.length-2; i >= 0; i--) {
            var mountain = mountains[i];
            for (int y = 0; y < height; y++) {
                var line = new StringBuilder();
                for (int x = 0; x < width; x++) {
                    var currChar = mountain[y].charAt(x);
                    var mainChar = main[y].charAt(x);
                    if (currChar == '/' || currChar == '\\' || currChar == 'X') {
                        line.append(currChar);
                    } else {
                        line.append(mainChar);
                    }
                }
                main[y] = line.toString();
            }
        }
        return String.join("\r\n", main);
    }
}
