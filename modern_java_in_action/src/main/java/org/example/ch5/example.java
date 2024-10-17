package org.example.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.example.ch5.Dish.menu;

public class example {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = nums.stream()
                .map(num -> num * num)
                .collect(toList());
//        System.out.println(squares);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap( i -> {
                    System.out.println(i + " : ");
                    return numbers2.stream()
                                    .map( j -> {
                                        int[] ne = new int[]{ i, j };
                                        System.out.println(ne[0] + " " + ne[1]);
                                        return ne;
                                    });
                }
                )
                .filter( arr -> (arr[0] + arr[1]) % 3 == 0)
                .toList();

        pairs.stream()
                .filter( t -> {
                    System.out.println(t[0] + "  " + t[1]);
                    return true;
                })
                .toList();

        Optional<Integer> total = menu.stream()
                .map(x -> 1)
                .reduce((x, y) -> x+y);

        System.out.println(total.get());
    }
}
