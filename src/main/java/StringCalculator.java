import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        return getSum(tokenize(text));
    }

    private String[] tokenize(String text) {
        if (hasCustomDelim(text)) {

            return splitWithCustomDelim(text);
        }

        return splitWIthNewlineAndComma(text);
    }

    private String[] splitWIthNewlineAndComma(String text) {

        return text.split(",|\n");
    }

    private String[] splitWithCustomDelim(String text) {
        final Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        matcher.matches();

        final String delim = matcher.group(1);
        final String numbers = matcher.group(2);

        return numbers.split(Pattern.quote(delim));
    }

    private boolean hasCustomDelim(String text) {

        return text.contains("//");
    }

    private int getSum(String[] split) {

        return Stream.of(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
