package sberfight.longest_path_in_caves;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Дан массив пещерных ходов cave. Значения в массиве указывают номер пещеры, куда из текущей пещеры можно пройти.
Например, cave[2, 2, 1] означает, что пещеры с индексом 0 и 1 пути ведут в пещеру с индексом 2.
А из cave[2] можно попасть в cave[1].
Определите индекс пещеры, из которой будет самый длинный путь до элемента массива со значением -1.
Ввод: cave - целочисленный массив пещер, 1<length(cave)
*/

public class LongestPathInCaves {
    public static void main(String[] args) {
        LongestPathInCaves.execute(new int[]{-1, 0, 0, 1, 2, 3, 4, 5});
    }

    public static int execute(int[] nums) {
        HashMap<Integer,List<Integer>> graphMap = new HashMap<>();
        int exitValue = -1;
        int currentNode = 0;
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == exitValue) {
                currentNode = i;
            }
            if (graphMap.containsKey(nums[i])) {
                graphMap.get(nums[i]).add(i);
            } else {
                graphMap.put(nums[i], new ArrayList<>(List.of(i)));
            }
        }

        TreeMap<Integer, Integer> maxLength = new TreeMap();
        maxDepth(graphMap, currentNode, length, maxLength);

        return maxLength.lastKey();
    }

    public static int maxDepth(Map<Integer, List<Integer>> graphMap, int currentNode, int length, TreeMap<Integer, Integer> maxLength) {
        while (graphMap.containsKey(currentNode)) {
            length++;
            if (graphMap.get(currentNode).size() > 1) {
                for(var i : graphMap.get(currentNode)) {
                    currentNode = maxDepth(graphMap, i, length, maxLength);
                }
            } else {
                currentNode = graphMap.get(currentNode).get(0);
            }
        }
        maxLength.putIfAbsent(currentNode, length);

        return currentNode;
    }
}
