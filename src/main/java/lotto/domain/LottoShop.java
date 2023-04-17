package lotto.domain;

public class LottoShop {

	private int LOTTO_PRICE = 1000;

	private LottoShop() {
	}

	public static LottoShop init() {
		return new LottoShop();
	}

	public Lottos sell(int money, NumbersGenerable numbersGenerable) {
		return Lottos.of(money / LOTTO_PRICE, numbersGenerable);
	}

}
