package org.example;

import java.util.Arrays;

public class Main {
    public static String serialize(int[] numbers) {
        StringBuilder serializedString = new StringBuilder();
        for (int number : numbers) {
            serializedString.append(number).append(',');
        }
        return serializedString.toString();
    }

    public static int[] deserialize(String serializedString) {
        String[] tokens = serializedString.split(",", -1);
        return Arrays.stream(tokens)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 3, 4, 5},      // Простейший случай
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},  // 10 чисел
                {100, 200, 300, 400, 500},  // 5 чисел с тремя знаками
                {5, 15, 25, 35, 45, 55, 65, 75, 85, 95},  // 10 чисел, все заканчиваются на 5
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},  // Массив из одинаковых чисел
                {1},  // Одно число
                {},  // Пустой массив
        };

        for (int[] test : tests) {
            String originalString = serialize(test);
            int[] deserializedArray = deserialize(originalString);

            System.out.println("Original: " + originalString.substring(0, Math.min(originalString.length(), 50)) + "...");
            System.out.println("Deserialized: " + Arrays.toString(deserializedArray));
            System.out.println("Equal: " + Arrays.equals(test, deserializedArray));
            System.out.println();
        }
    }
}