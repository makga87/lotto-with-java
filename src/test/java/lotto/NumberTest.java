package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 47})
    void testNumberValidation(int exceptionNumber) {
        Throwable throwable = catchThrowable(() -> Number.from(exceptionNumber));
        assertThat(throwable).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid number input");
    }

    @Test
    void testEqualsNumber(){
       assertTrue(Number.from(1).equals(Number.from(1)));
    }

}