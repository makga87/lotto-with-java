package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

	@DisplayName("로또에서 지원하지 않는 번호가 입력되는 경우, 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 47})
    void testNumberValidation(int exceptionNumber) {
        Throwable throwable = catchThrowable(() -> Number.from(exceptionNumber));
        assertThat(throwable).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid number input");
    }

	@DisplayName("동일한 번호의 객체는, 동치성이 성립한다")
    @Test
    void testEqualsNumber(){
       assertTrue(Number.from(1).equals(Number.from(1)));
    }

}