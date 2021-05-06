package com.psdorofeev;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
    public static int getMax(int[][] input, int base)
    {
        List<Integer> resultSums = new ArrayList<>();

        Arrays.stream(input)
            .forEach(row ->
                     {
                         List<Integer> currentSums = IntStream.range(0, row.length)
                             .flatMap(i -> IntStream.range(i + 1, row.length).map(j -> row[j] + row[i]))
                             .boxed()
                             .collect(Collectors.toList());

                         /* it could be simplify like below, but what if we'll have N digits in each row?
                         currentSums.add(row[0] + row[1]);
                         currentSums.add(row[0] + row[2]);
                         currentSums.add(row[1] + row[2]);
                         */

                         currentSums = mergeCartesian(currentSums, resultSums);
                         deleteDuplicates(currentSums, base);

                         resultSums.clear();
                         resultSums.addAll(currentSums);
                     });

        return resultSums.stream()
            .filter(v -> v % base == 0)
            .mapToInt(v -> v)
            .max()
            .orElse(0);
    }

    private static void deleteDuplicates(List<Integer> currentSums, int base)
    {
        currentSums.retainAll(currentSums.stream()
                                  .collect(Collectors.groupingBy(v -> v % base,
                                                                 Collectors.maxBy(Comparator.comparingInt(v -> v))))
                                  .values().stream()
                                  .map(Optional::get)
                                  .collect(Collectors.toList()));
    }

    private static List<Integer> mergeCartesian(List<Integer> list1, List<Integer> list2)
    {
        if (list2.isEmpty())
        {
            return list1;
        }

        return list1.stream()
            .flatMap(a1 -> list2.stream().map(b1 -> b1 + a1))
            .collect(Collectors.toList());
    }
}
