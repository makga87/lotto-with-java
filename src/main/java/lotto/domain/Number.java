package lotto.domain;

import java.util.Objects;

public class Number {

	private int number;

	private Number(int number) {
		this.number = number;
	}

	public static Number from(int number) {
		validate(number);
		return new Number(number);
	}

	public int getNumber() {
		return this.number;
	}

	private static void validate(int number) {
		if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
			throw new IllegalArgumentException("Invalid number input");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Number numberObject = (Number) o;
		return number == numberObject.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
