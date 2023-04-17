package lotto;

import java.util.Comparator;

public class NumbersComparator implements Comparator<Numbers> {

	private int matchingCount;

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
