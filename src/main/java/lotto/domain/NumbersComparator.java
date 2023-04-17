package lotto.domain;

import java.util.Comparator;

public class NumbersComparator implements Comparator<Numbers> {

	private int matchingCount;

	private NumbersComparator() {
	}

	public static NumbersComparator init() {
		return new NumbersComparator();
	}

	@Override
	public int compare(Numbers clientNumbers, Numbers winningNumbers) {
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
