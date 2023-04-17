package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.NumbersAutoGenerator;

public class LottoService {

	public void execute() {

		int money = 14000;

		LottoShop lottoShop = LottoShop.init();

		Lottos myLottos = lottoShop.sell(money, NumbersAutoGenerator.init());


	}
}
