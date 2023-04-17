package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Numbers {

	private List<Number> numbers;

	private Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public static Numbers from(List<Number> numbers) {
		validate(numbers);
		return new Numbers(Collections.unmodifiableList(numbers));
	}

	private static void validate(List<Number> numbers) {
		if (numbers.size() != LottoConstants.NUMBER_SIZE) {
			throw new IllegalArgumentException("Invalid number size");
		}
	}

	public boolean contain(Number number) {
		return this.numbers.contains(number);
	}

	public Stream<Number> getNumbers() {
		return this.numbers.stream();
	}
}
