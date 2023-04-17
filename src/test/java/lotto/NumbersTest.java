package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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

	private List<Number> generateNumbers(int size) {

		List<Number> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			numbers.add(Number.from(i + 1));
		}
		return numbers;
	}
}