package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String DEFAULT_VALUE = "0";
    private final String text;
    private final Splitter splitter;
    private List<Number> numbers = new ArrayList<>();

    public StringCalculator(String text) {
        this.text = text;
        splitter = new Splitter(text);

    }

    private void assignNumber() {
        if (isNullValue()) {
            numbers = List.of(Number.of(DEFAULT_VALUE));
            return;
        }
        numbers = splitter.splittingText()
            .map(Number::of)
            .collect(Collectors.toList());
    }

    public int add() {
        assignNumber();
        return numbers.stream()
            .reduce(Number.of(DEFAULT_VALUE), Number::plus)
            .getValue();
    }

    private boolean isNullValue() {
        return text == null || text.isBlank();
    }

}
