package lotto.domain;

public class NumbersMatchingCounter {

	private int matchingCount;

	private NumbersMatchingCounter() {
	}

	public static NumbersMatchingCounter init() {
		return new NumbersMatchingCounter();
	}

	public int count(Numbers clientNumbers, Numbers winningNumbers) {
		clientNumbers.getNumbers()
					 .forEach(number -> plusMatchingCount(winningNumbers.contain(number)));
		return this.matchingCount;
	}

	private void plusMatchingCount(boolean contain) {
		if (contain) {
			this.matchingCount++;
		}
	}
}
