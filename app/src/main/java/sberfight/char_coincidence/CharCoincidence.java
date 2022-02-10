package sberfight.char_coincidence;

import java.util.TreeSet;

/*
Дана строка s. Вы можете удалить из нее не более k символов.

Определите максимально возможное количество совпадений символов с stringGoal, то есть совпадением считается s[i] = stringGoal[i].

Например, строка "agddb" совпадает с "gdda" только одним символом. Если убрать первый символ, тогда будет уже 3 совпадения - "gddb" "gdda".

Ввод:

s - строка с символами, 0<length(s)<20
k - максимальное количество удалений, 0<k<10
stringGoal - строка для сравнения
Вывод:

Integer - максимальное количество совпадений s[i] = stringGoal[i]

Пример:

s = "agdd"
k = 1
stringGoal = "gdd"
getResult(s, k, stringGoal) = 3
 */
public class CharCoincidence {
    public static void main(String[] args) {
        int result = getResult("dd_gd_gdd", 1, "gdd");
    }

    public static int getResult(String s, int k, String stringGoal) {
        TreeSet<Integer> maxCoincidenceSet = new TreeSet<>();
        int skip = 0;
        int offset = 0;
        int i = 0;

        while (i + offset + skip < s.length()) {
            //Обходим каждый раз с нуля строку поиска и ищем вхождения

            if (stringGoal.charAt(i) == s.charAt(i + offset + skip)) {
                i++;
                if (i >= stringGoal.length()
                        && (i + offset + skip) < s.length()) {
                    i = 0;
                }
            } else {
                if (skip < k) {
                    skip++;
                } else {
                    offset += skip + 1;
                    skip = 0;
                }
                i = 0;
            }

            maxCoincidenceSet.add(i);
        }

    return maxCoincidenceSet.last();
    }
}
