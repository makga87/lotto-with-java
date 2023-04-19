package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	@DisplayName("설정한 갯수만큼 로또가 생성되는지 확인한다")
	@Test
	void ofTest() {

		int inputCnt = 10;

		Lottos lottos = Lottos.of(inputCnt, NumbersAutoGenerator.init());
		long expectedCnt = lottos.getLottos().count();

		assertEquals(expectedCnt, expectedCnt);
	}
}