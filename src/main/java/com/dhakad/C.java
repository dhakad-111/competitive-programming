package com.dhakad;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 2};


        Map<Integer, Long> collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> sortedByCount = collect.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // Fixed line
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    }
}
