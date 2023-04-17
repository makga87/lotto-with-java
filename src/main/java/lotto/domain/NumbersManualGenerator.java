package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersManualGenerator implements NumbersGenerable {

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
		return Arrays.stream(numbers.split(SEPARATOR_CHARACTER))
					 .map(numberString -> Number.from(Integer.parseInt(numberString)))
					 .collect(Collectors.toList());
	}

}
