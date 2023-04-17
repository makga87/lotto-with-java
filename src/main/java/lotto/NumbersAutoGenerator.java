package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersAutoGenerator implements NumbersGenerable {

	private NumbersAutoGenerator() {
	}

	public static NumbersAutoGenerator init() {
		return new NumbersAutoGenerator();
	}

	@Override
	public Numbers generate() {
		List<Number> numberList = getNumberList();
		Collections.shuffle(numberList);
		return Numbers.from(numberList.subList(0, LottoConstants.NUMBER_SIZE));
	}

	private List<Number> getNumberList() {
		return IntStream.rangeClosed(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER)
						.mapToObj(val -> Number.from(val))
						.collect(Collectors.toList());
	}


}
