package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersMatchingCounterTest {


	@DisplayName("자동 생성 로또 번호를 비교하여, 동일한 번호 갯수 만큼 비교결과를 반환한다 ")
	@ParameterizedTest
	@MethodSource("provideNumbers")
	void counterTest(Numbers clientNumbers, Numbers winningNumbers, int expected) {

		NumbersMatchingCounter comparator = NumbersMatchingCounter.init();
		int actual = comparator.count(clientNumbers, winningNumbers);

		assertEquals(expected, actual);
	}


	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(Numbers.from(Arrays.asList(
									 Number.from(42),
									 Number.from(2),
									 Number.from(13),
									 Number.from(12),
									 Number.from(10),
									 Number.from(25))),
							 Numbers.from(Arrays.asList(
									 Number.from(42),
									 Number.from(2),
									 Number.from(13),
									 Number.from(12),
									 Number.from(10),
									 Number.from(25))),
							 6
							),
				Arguments.of(Numbers.from(Arrays.asList(
									 Number.from(1),
									 Number.from(2),
									 Number.from(3),
									 Number.from(4),
									 Number.from(5),
									 Number.from(6))),

							 Numbers.from(Arrays.asList(
									 Number.from(6),
									 Number.from(2),
									 Number.from(13),
									 Number.from(3),
									 Number.from(5),
									 Number.from(25))),
							 4
							)
						);
	}
}

