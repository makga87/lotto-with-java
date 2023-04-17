package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersManualGeneratorTest {


	@ParameterizedTest
	@CsvSource(value = {
			"1, 2, 3, 4, 5, ",
			"a, 2, 3, 4, 5, 6",
			"%, 2, 3, 4, 5, 6",
	}, delimiter = ':')
	void generateTest(String numberString) {

		NumbersManualGenerator numbersManualGenerator = NumbersManualGenerator.from(numberString);
		Throwable throwable = catchThrowable(() -> numbersManualGenerator.generate());
		assertThat(throwable).
				isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Invalid number string input");
	}
}