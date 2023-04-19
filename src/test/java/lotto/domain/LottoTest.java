package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@DisplayName("로또 번호 생성 메서드가 정상동작하는지 확인한다")
	@Test
	void generateTest() {

		Lotto lotto = Lotto.generate(() -> Numbers.from(Arrays.asList(
				Number.from(1),
				Number.from(2),
				Number.from(3),
				Number.from(4),
				Number.from(5),
				Number.from(6))));


		boolean isEquals = lotto.getNumbers()
								.equals(Numbers.from(Arrays.asList(
										Number.from(1),
										Number.from(2),
										Number.from(3),
										Number.from(4),
										Number.from(5),
										Number.from(6))));

		assertTrue(isEquals);
	}

	@DisplayName("생성된 로또 번호 문자열이 잘 출력되는지 확인한다.")
	@Test
	void toStringTest() {
		Lotto lotto = Lotto.generate(() -> Numbers.from(Arrays.asList(
				Number.from(1),
				Number.from(2),
				Number.from(3),
				Number.from(4),
				Number.from(5),
				Number.from(6))));

		assertEquals("[1,2,3,4,5,6]", lotto.toString());
	}
}