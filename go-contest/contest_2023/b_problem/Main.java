import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            String str = sc.nextLine();
            result.append(isShipCorrect(str) + "\r\n");
        }
        System.out.println(result.toString());
        sc.close();
    }

    public static String isShipCorrect(String str) {
        Map<String, Integer> shipMap = new HashMap<>();
        String[] arr = str.split(" ");
        for (String s : arr) {
            if (shipMap.containsKey(s)) {
                shipMap.put(s, shipMap.get(s) + 1);
            } else {
                shipMap.put(s, 1);
            }
        }
    }
}
