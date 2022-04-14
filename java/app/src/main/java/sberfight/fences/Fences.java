package sberfight.fences;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Fences {

    public static int matches;

    public static void main(String[] args) {
        Fences.getResult(List.of(0, 2, 3, 3, 3)); //4, 1 или 3, 2 true

    }

    public static boolean isPalindrome(List<Integer> numb) {
        //Arrays.sort(nums);
        //1. Step by step itterate by array
        //2. If value greater than nums size, then skip
        //3.

        var list = numb.stream().collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
                .entrySet()
                .stream()
                .filter( p -> p.getValue() == 1 || p.getValue() > 2 )
                .map( Map.Entry::getKey )
                .collect( Collectors.toList() );

        return list.size() <= 1;
    }

    public static int computerAction(List<String> actions) {
        actions = List.of("power", "keystrokes", "click", "click", "power", "click", "click");

        boolean power = false;
        boolean login = false;
        int openApp = 0;

        for (int i = 0; i < actions.size(); i++) {
            if (actions.get(i).equals("power")) {
                power = !power;
                if (power == false) {
                    login = false;
                }
            }

            if (actions.get(i).equals("keystrokes")) {
                if (power) {
                    login = true;
                }
            }

            if (actions.get(i).equals("click")) {
                if (!power || !login) {
                    continue;
                }
                if (i < actions.size()-1) {
                    if (actions.get(i+1).equals("click")) {
                        openApp++;
                        i++;
                    }
                }
            }

        }

        System.out.println(openApp);
        return openApp;
    }



    public static boolean getResult(List<Integer> fences) {

        var fencesSize = fences.stream().map((x) -> {
            return x < fences.size() ? x : 0;
        }).collect(Collectors.toList());

        startCycles(fences, 0, 0);

        return matches > 0;
    }

    public static void startCycles(List<Integer> arr, int sum, int counter) {
        int levelSum = sum;
        for (int i = counter; i < arr.size(); i++) {
            var currentSum = levelSum + arr.get(i);
            if (currentSum == arr.size() - 1) {
                matches++;
            }
            startCycles(arr, currentSum, i + 1);
        }
    }
}
