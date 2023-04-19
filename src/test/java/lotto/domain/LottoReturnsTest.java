package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoReturnsTest {

	@DisplayName("로또번호 일치 갯수에 대한 카운팅이 정상 동작함을 확인한다")
	@ParameterizedTest
	@CsvSource({
			"6, 0, 1",
			"5, 0, 1",
			"4, 0, 1",
			"3, 0, 1",
			"2, 0, 0",
			"1, 0, 0",
			"0, 0, 0",
	})
	void countPlusReturnsTest(int matchingCount, int defaultExpected, int expected) {

		WinningsTable winningsTable = WinningsTable.getByMatchingCount(matchingCount);
		LottoReturns lottoReturns = LottoReturns.from(10000);
		int count = lottoReturns.getCount(winningsTable);
		assertEquals(defaultExpected, count);

		lottoReturns.countPlusReturns(winningsTable);
		count = lottoReturns.getCount(winningsTable);
		assertEquals(expected, count);
	}


	@DisplayName("수익률 계산 테스트를 진행한다")
	@Test
	void getReturnsTest() {
		LottoReturns lottoReturns = LottoReturns.from(14000);
		lottoReturns.countPlusReturns(WinningsTable.FORTH_PLACE);

		String returns = String.format("%.2f", lottoReturns.getReturns());
		assertEquals("0.35", returns);
	}
}