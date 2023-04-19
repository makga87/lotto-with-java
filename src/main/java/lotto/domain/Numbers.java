package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Numbers _numbers = (Numbers) o;

		boolean flag = true;
		for (Number number : numbers) {
			flag = flag & _numbers.contain(number);
		}

		return flag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
