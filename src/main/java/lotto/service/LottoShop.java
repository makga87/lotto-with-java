package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.NumbersGenerable;

public class LottoShop {

	private int LOTTO_PRICE = 1000;

	public Lottos sell(int money, NumbersGenerable numbersGenerable) {
		return Lottos.of(money / LOTTO_PRICE, numbersGenerable);
	}

}
