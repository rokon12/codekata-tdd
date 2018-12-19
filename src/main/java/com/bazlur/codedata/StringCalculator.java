package com.bazlur.codedata;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isBlank()) {

            return 0;
        } else {

            return Stream.of(tokenize(numbers))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
    }

    private String[] tokenize(String numbers) {

        return hasCustomDelimiter(numbers)
                ? splitWithCustomDelimiter(numbers)
                : splitWithCommaAndNewLine(numbers);
    }

    private boolean hasCustomDelimiter(String numbers) {

        return numbers.startsWith("//");
    }

    private String[] splitWithCommaAndNewLine(String numbers) {

        return numbers.split(",|\n");
    }

    private String[] splitWithCustomDelimiter(String numbers) {
        var pattern = Pattern.compile("//(.)\n(.*)");
        var matcher = pattern.matcher(numbers);
        matcher.matches();
        var customDelim = matcher.group(1);
        var num = matcher.group(2);

        return num.split(Pattern.quote(customDelim));
    }
}
