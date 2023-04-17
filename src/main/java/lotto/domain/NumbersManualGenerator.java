package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersManualGenerator implements NumbersGenerable {

	private final String NUMBER_REGEXP = "^[0-9]+$";

	private final String SEPARATOR_CHARACTER = ",";
	private String numbers;

	private NumbersManualGenerator(String numbers) {
		this.numbers = numbers;
	}

	public static NumbersManualGenerator from(String numbers) {
		return new NumbersManualGenerator(numbers);
	}

	@Override
	public Numbers generate() {
		return Numbers.from(convertToNumberList(this.numbers));
	}

	private List<Number> convertToNumberList(String numbers) {
		String[] numberStringArray = numbers.split(SEPARATOR_CHARACTER);
		validate(numberStringArray);
		return Arrays.stream(numberStringArray)
					 .map(numberString -> Number.from(Integer.parseInt(numberString)))
					 .collect(Collectors.toList());
	}

	private void validate(String[] numberStringArray) {
		for (String numberString : numberStringArray) {
			checkString(numberString);
		}
	}

	private void checkString(String numberString) {
		if (!numberString.matches(NUMBER_REGEXP)) {
			throw new IllegalArgumentException("Invalid number string input");
		}
	}

}
