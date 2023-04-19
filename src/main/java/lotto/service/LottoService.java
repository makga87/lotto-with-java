package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoReturns;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.NumbersAutoGenerator;
import lotto.domain.NumbersManualGenerator;
import lotto.domain.NumbersMatchingCounter;
import lotto.domain.WinningsTable;
import lotto.view.InputView;

public class LottoService {

	private LottoService() {
	}

	public static LottoService init() {
		return new LottoService();
	}

	public Lottos buyLotto(int money) {
		LottoShop lottoShop = LottoShop.init();
		return lottoShop.sell(money, NumbersAutoGenerator.init());
	}

	public Lotto checkWinningLotto() {
		return Lotto.generate(NumbersManualGenerator.from(InputView.inputWinningNumber()));
	}

	public LottoReturns compareWithMyLotto(Lottos myLottos, Lotto winningLotto, int money) {
		LottoReturns lottoReturns = LottoReturns.from(money);

		myLottos.getLottos()
				.forEach(lotto -> {
					NumbersMatchingCounter numbersMatchingCounter = NumbersMatchingCounter.init();
					int matchCount = numbersMatchingCounter.count(lotto.getNumbers(), winningLotto.getNumbers());
					WinningsTable winningsTable = WinningsTable.getByMatchingCount(matchCount);
					lottoReturns.countPlusReturns(winningsTable);
				});

		return lottoReturns;
	}
}
