package org.example.tdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class StringCalculator implements Calculator{

    private String message="Negative numbers are not allowed here. Value of: %s";
    private String negativeNumbers;

    @Override
    public int add(String numbers) {
        negativeNumbers=getNegativeNumbers(numbers);
        String spliterator="[^\\d|-]+";
        List <String> stringList= Arrays.asList(numbers.split(spliterator));
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .map(this::validateNumber)
                .sum();
    }

    private String getNegativeNumbers(String numbers) {
        String spliterator="[^\\d|-]+";
        List <String> stringList= Arrays.asList(numbers.split(spliterator));
        List<Integer> integerList=stringList.stream()
                 .map(Integer::parseInt)
                 .filter(x->x<0)
                 .collect(Collectors.toList());
        negativeNumbers=integerList.toString();
        return negativeNumbers;
    }

    private int validateNumber(int i) {
        if (i<0) {
            throw new RuntimeException( String.format(message, negativeNumbers));
        }
        return i;
    }
}
