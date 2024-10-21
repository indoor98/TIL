package org.example.ch6;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static org.example.ch6.Dish.menu;

public class notebook2 {
    public static void main(String[] args) {

        // 6.3.2 다수준 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                })
                        )
                );
        System.out.println(dishesByTypeCaloricLevel);

        // 6.3.3 서브그룹으로 데이터 수집
        Map<Dish.Type, Long> typesByCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesByCount);

        Map<Dish.Type, Optional<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(dishesByType);

        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType);

        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }, toSet())));

        System.out.println(caloricLevelsByType);


        // 6.4 분할
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(
                partitioningBy(Dish::isVegetarian)
        );
        System.out.println(partitionedMenu);

        // 6.4.1 분할의 장점
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishedByType = menu.stream().collect(
                partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType))
        );
        System.out.println(vegetarianDishedByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);

        System.out.println(isPrime(4));
        System.out.println(partitionPrimes(10));
    }


    // 6.4.2 숫자를 소수와 비소수로 구별하기
//    public static boolean isPrime(int candidate) {
//        return IntStream.range(2, candidate)
//                .noneMatch(i -> candidate % i == 0);
//    }

    public static boolean isPrime(int n) {
        int candidateRoot = (int) Math.sqrt((double) n);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> n % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

}
