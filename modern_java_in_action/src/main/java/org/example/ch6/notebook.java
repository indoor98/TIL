package org.example.ch6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.ch6.Dish.menu;

public class notebook {

    public static void main(String[] args) {

        long howManyDished = menu.stream().collect(Collectors.counting());
        System.out.println(howManyDished);
        System.out.println(menu.stream().count());

        // 최대, 최소 계산
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        System.out.println( mostCalorieDish.orElse(null));

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
    }
}
