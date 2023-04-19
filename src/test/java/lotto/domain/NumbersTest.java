package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

	@DisplayName("로또 번호가 지정된 갯수 이상으로 구성된 경우 예외를 발생시킨다 ")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 7})
	void numberSizeTest(int size) {
		Throwable throwable = catchThrowable(() -> Numbers.from(generateNumbers(size)));
		assertThat(throwable).
				isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Invalid number size");
	}

	@DisplayName("지정된 번호가 로또번호리스트에 포함되어 있으면 true를, 없으면 false를 반환한다")
	@ParameterizedTest
	@CsvSource({
			"1, true",
			"2, true",
			"3, true",
			"4, true",
			"5, true",
			"6, true",
			"7, false",
			"8, false",

	})
	void numberContainTest(int number, boolean expected) {
		Numbers numbers = Numbers.from(generateNumbers(6));
		assertEquals(expected, numbers.contain(Number.from(number)));
	}

	@DisplayName("값의 순서와 관계없이, 같은 숫자를 전부 포함하면, 같은 값으로 판단한다")
	@Test
	void equalsTest() {
		Numbers numbers = Numbers.from(Arrays.asList(
				Number.from(1),
				Number.from(2),
				Number.from(3),
				Number.from(4),
				Number.from(5),
				Number.from(6)));

		Numbers compareTarget = Numbers.from(Arrays.asList(
				Number.from(1),
				Number.from(3),
				Number.from(2),
				Number.from(4),
				Number.from(6),
				Number.from(5)));

		assertTrue(numbers.equals(compareTarget));

	}


	private List<Number> generateNumbers(int size) {

		List<Number> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			numbers.add(Number.from(i + 1));
		}
		return numbers;
	}
}