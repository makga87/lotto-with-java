package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoConstants;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.NumbersAutoGenerator;

class NumbersAutoGeneratorTest {

	@DisplayName("로또 번호가 랜덤하게, 생성되어 반환된다")
	@Test
	void generateTest() {

		NumbersAutoGenerator numbersAutoGenerator = NumbersAutoGenerator.init();
		Numbers numbers = numbersAutoGenerator.generate();
		numbers.getNumbers()
			   .forEach(number -> {
				   System.out.println(number.getNumber());
			   });
	}


	/**
	 * 0, 47에 대한 유효성 검증은 NumberTest에서 진행
	 */
	@DisplayName("로또 번호 생성기에서 1 ~ 46 까지의 번호만 생성된다")
	@ParameterizedTest
	@CsvSource({
			"1, true",
			"46, true"
	})
	void getNumberListTest(int number, boolean expected) {
		List<Number> numberList = IntStream.rangeClosed(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER)
										   .mapToObj(val -> Number.from(val))
										   .collect(Collectors.toList());

		Assertions.assertEquals(expected, numberList.contains(Number.from(number)));
	}
}