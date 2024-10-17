package org.example.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.example.ch4.Dish.menu;

public class example {
    public static void main(String[] args) {
//        List<String> highCaloricDishes = new ArrayList<>();
//        Iterator<Dish> iterator = menu.iterator();
//        while(iterator.hasNext()) {
//                Dish dish = iterator.next();
//                if(dish.getCalories() > 300) {
//                    highCaloricDishes.add(dish.getName());
//                }
//        }
//        System.out.println(highCaloricDishes);
//
//        List<String> highCaloricCaloricDishes = menu.stream()
//                .filter(dish -> dish.getCalories()>300)
//                .map(d -> d.getName())
//                .collect(toList());
//        System.out.println(highCaloricDishes);
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories()>300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
    }
}
