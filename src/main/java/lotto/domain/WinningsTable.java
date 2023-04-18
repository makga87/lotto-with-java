package lotto.domain;

import java.util.Arrays;

public enum WinningsTable {

	FIRST_PLACE(6, 2000000000),
	SECOND_PLACE(5, 1500000),
	THIRD_PLACE(4, 50000),
	FORTH_PLACE(3, 5000),
	NONE(0, 0);

	private int matchingCount;
	private int money;

	WinningsTable(int matchingCount, int money) {
		this.matchingCount = matchingCount;
		this.money = money;
	}

	public static WinningsTable getByMatchingCount(int matchingCount) {
		return Arrays.stream(values())
					 .filter(winningsTable -> winningsTable.matchingCount == matchingCount)
					 .findAny()
					 .orElseGet(() -> WinningsTable.NONE);
	}

	public int getMoney() {
		return this.money;
	}
}
