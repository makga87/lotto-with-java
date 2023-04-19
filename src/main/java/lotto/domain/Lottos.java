package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {

	private List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos of(int count, NumbersGenerable numbersGenerable) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottoList.add(Lotto.generate(numbersGenerable));
		}
		return new Lottos(Collections.unmodifiableList(lottoList));
	}

	public Stream<Lotto> getLottos() {
		return lottos.stream();
	}
}
