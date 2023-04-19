package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.WinningsTable;

class WinningsTableTest {

	@ParameterizedTest
	@CsvSource({
			"6, 2000000000",
			"5, 1500000",
			"4, 50000",
			"3, 5000",
			"2, 0",
			"1, 0",
			"0, 0",
	})
	void getByMatchingCountTest(int matchCount, int expected) {

		WinningsTable winningsTable = WinningsTable.getByMatchingCount(matchCount);
		assertEquals(expected, winningsTable.getMoney());
	}
}