package org.example.ch5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class solution {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Transaction> prob1 = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println(prob1);

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> prob2 = transactions.stream()
                .map(tr -> tr.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println(prob2);

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<String> prob3 = transactions.stream()
                .filter(tr -> tr.getTrader().getCity().equals("Cambridge"))
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted((x, y) -> x.compareTo(y))
                .toList();
        System.out.println(prob3);

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        List<String> prob4 = transactions.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted((x, y) -> x.compareTo(y))
                .toList();
        System.out.println(prob4);

        // 5. 밀라노에 거래자가 있는가?
        boolean prob5 = transactions.stream()
                .anyMatch(tr -> tr.getTrader().getCity().equals("Milan"));
        System.out.println(prob5);

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        Optional<Integer> prob6 = transactions.stream()
                .filter(tr -> tr.getTrader().getCity().equals("Cambridge"))
                .map(tr -> tr.getValue())
                .reduce( (x, y) -> x + y );

        System.out.println(prob6.orElse(0));

        // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
        Optional<Integer> prob7 = transactions.stream()
                .map(tr -> tr.getValue())
                .reduce( (x, y) -> x<y ? y : x);

        System.out.println(prob7.orElse(0));


        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?

        Optional<Integer> prob8 = transactions.stream()
                .map(tr -> tr.getValue())
                .reduce( (x, y) -> x>y ? y : x);

        System.out.println(prob8.orElse(0));
    }
}
