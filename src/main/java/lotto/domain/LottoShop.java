package lotto.domain;

public class LottoShop {


	private LottoShop() {
	}

	public static LottoShop init() {
		return new LottoShop();
	}

	public Lottos sell(int count, NumbersGenerable numbersGenerable) {
		return Lottos.of(count, numbersGenerable);
	}

}
