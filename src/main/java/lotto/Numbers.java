package lotto;

import java.util.Collections;
import java.util.List;

public class Numbers {

	private static final int NUMBER_SIZE = 6;

	private List<Number> numbers;

	private Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public static Numbers from(List<Number> numbers) {
		validate(numbers);
		return new Numbers(Collections.unmodifiableList(numbers));
	}

	private static void validate(List<Number> numbers) {
		if (numbers.size() != NUMBER_SIZE) {
			throw new IllegalArgumentException("Invalid number size");
		}
	}

}
