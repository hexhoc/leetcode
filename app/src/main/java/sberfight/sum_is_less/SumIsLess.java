package sberfight.sum_is_less;

/*
На вход подается числовой массив.
За одну операцию вы можете разделить любое число в массиве
на два (целочисленное деление).
Определите, может ли сумма всех элементов в массиве
быть не больше w.
Общее количество операций не должно превышать значение
самого большого числа в массиве.
Возможное общее количество операций меняется динамически,
то есть если Вы будете делить самое крупное число,
то общее количество возможных операций уменьшится.
Ввод:
* arr - массив чисел (integer[]), 1<length(arr)<10
* w - число, максимальный предел для суммы массива (integer), 0<w<100
Вывод:
Boolean - возможно ли удовлетворить условие sum(arr) <= w
Пример:
arr = [3, 2, 4, 5]
W = 9
get_result(arr, W) = true
Сначала количество возможных операций равно 5
(самое большое число в исходном массиве)
5 // 2 = 2 [3, 2, 4, 2], теперь количество проведенных
операций равно 1, а число возможных операций - 4
4 // 2 = 2 [3, 2, 2, 2], теперь количество проведенных
операций равно 2, а число возможных операций - 3
Уже сейчас выполняется условие: 3 + 2 + 2 + 2 <= 9
 */


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumIsLess {
    public static void main(String[] args) {
        SumIsLess.execute(new int[]{3, 2, 4, 5}, 9);
        SumIsLess.execute(new int[]{52, 2, 2, 2, 2}, 14);
    }

    public static boolean execute(int[] nums, int w) {
        List<Integer> numsList = IntStream.range(0, nums.length)
                .boxed()
                .map(i -> nums[i])
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());


        TreeSet<Integer> setOfSum = new TreeSet<>();
        setOfSum.add(calculateSum(numsList));

        return setOfSum.first()<=w;
    }

    public static int calculateSum(List<Integer> numsList) {
        int stepLimit = numsList.get(0);
        int stepCounter = 0;
        int i = 0;
        int skip = 0;
        boolean doNext = false;
        while (stepCounter < stepLimit) {
            if (i == numsList.size() - 1) {
                i = 0;
                skip = 0;
            }

            if (numsList.get(i)==0) {
                skip++;
                i++;
                if (skip == numsList.size()) {
                    break;
                }
                continue;
            }

            // Заранее рассчитываеаем текущий шаг и ограничения по шагам.
            // Если на этом шаге мы перейдем ограничение, то он не должен состояться
            doNext = false;
            stepCounter++;
            if (i < numsList.size()-1) {
                stepLimit = Math.max(numsList.get(i+1), numsList.get(i)/2);
                if (numsList.get(i+1)>numsList.get(i)/2) {
                    doNext = true;
                }
            } else {
                stepLimit = numsList.get(i)/2;
            }

            if (stepCounter > stepLimit) {
                break;
            }
            // divide
            numsList.set(i,numsList.get(i)/2);

            if (doNext) {
                i++;
            }
        }

        int sum = numsList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return sum;
    }

}
