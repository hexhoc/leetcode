package sberfight.array_change_step;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.google.common.base.Functions;

/*
Дан массив чисел array_start.
Вы можете менять местами элементы массива.
Ваша задача: получить array_goal.
Необходимо определить минимально возможное количество перемещений элементов массива,
которое требуется, чтобы получить нужный порядок в массиве.
Ввод:
* array_start - начальный массив, 1<length(array_start)<10
* array_goal - конечный массив, length(array_start)=length(array_goal)
Вывод:
* Integer
Пример:
array_start = [3, 2, 1, 4]
array_goal = [1, 2, 3, 4]
get_result(array_start, array_goal) = 1
Меняем 3 и 1 местами и получаем нужную последовательность в массиве.
*/

public class ArrayChangeStep {
    public static void main(String[] args) {
        int steps = ArrayChangeStep.execute_map(new int[]{4,3,4,3,3,2,1}, new int[]{3,4,3,4,1,2,3}); //2
        System.out.println(steps);
    }

    public static int execute_logN(int[] arrayStart, int[] arrayGoal) {
        int steps = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arrayStart.length; i++) {
            if (arrayStart[i] != arrayGoal[i]) {
                for (int j = i + 1; j < arrayStart.length; j++) {
                    if (arrayStart[j] == arrayGoal[i]) {
                        System.out.print(Arrays.toString(arrayStart));
                        System.out.println(" swap " + arrayStart[i] + " and " + arrayStart[j]);

                        int temp = arrayStart[j];
                        arrayStart[j] = arrayStart[i];
                        arrayStart[i] = temp;
                        steps++;
                        break;
                    }
                }
            }
        }
        System.out.println(System.currentTimeMillis() - startTime + " ms");

        return steps;
    }

    public static int execute_map(int[] arrayStart, int[] arrayGoal) {
        long startTime = System.currentTimeMillis();

        int steps = 0;
        HashMap<Integer, TreeSet<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < arrayStart.length; i++) {
            if (indexMap.containsKey(arrayStart[i])) {
                indexMap.get(arrayStart[i]).add(i);
            } else {
                indexMap.put(arrayStart[i], new TreeSet<>(Set.of(i)));
            }
        }

        TreeSet<Integer> set = new TreeSet<>();

//        Map<Integer, Integer> badPosition = IntStream
//            .range(0, arrayStart.length)
//            .boxed()
//            .collect(Collectors.toMap(Function.identity(), i->arrayStart[i]));

        for (int i = 0; i < arrayStart.length; i++) {
            if (arrayStart[i] != arrayGoal[i]) {
                // We get a list of indexes of the desired value
                int i2 = indexMap.get(arrayGoal[i]).higher(i);
                // index for swap must be greater than current index

//                System.out.print(Arrays.toString(arrayStart));
//                System.out.println(" swap " + arrayStart[i] + " and " + arrayStart[i2]);

                int temp = arrayStart[i];
                arrayStart[i] = arrayStart[i2];
                arrayStart[i2] = temp;

                steps++;

                //remove
                indexMap.get(arrayGoal[i]).remove(i2);
                //update
                indexMap.get(arrayStart[i2]).add(i2);
            }
        }

        System.out.println(System.currentTimeMillis() - startTime + " ms");
        return steps;
    }

}
