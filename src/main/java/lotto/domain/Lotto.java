package lotto.domain;

public class Lotto {

	private Numbers numbers;

	private Lotto(Numbers numbers) {
		this.numbers = numbers;
	}

	public static Lotto generate(NumbersGenerable numbersGenerable) {
		return new Lotto(numbersGenerable.generate());
	}

	public Numbers getNumbers() {
		return this.numbers;
	}

}
