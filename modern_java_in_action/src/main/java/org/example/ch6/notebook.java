package org.example.ch6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.example.ch6.Dish.menu;

public class notebook {

    public static void main(String[] args) {

        long howManyDished = menu.stream().collect(Collectors.counting());
        System.out.println(howManyDished);
        System.out.println(menu.stream().count());

        // 최대, 최소 계산
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        System.out.println(mostCalorieDish.orElse(null));

        // 6.2.2 요약 연산
        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        double averageCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(averageCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        // 6.2.3 문자열 연결
        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);

        // 6.2.4 범용 리듀싱 요약 연산
        int totalCalories2 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (x, y) -> x + y));
        System.out.println(totalCalories2);

        Optional<Dish> mostCalorieDish2 = menu.stream().collect(Collectors.reducing(
                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
        );
        System.out.println(mostCalorieDish2.orElse(null));

        // collect와 reduce
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                }
        );

        // 6.3 그룹화
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        // 6.3.1
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700){
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })
        );
        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList()))
        );
        System.out.println(caloricDishesByType);






    }
}
