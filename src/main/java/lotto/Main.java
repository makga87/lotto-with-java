package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoReturns;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

	public static void main(String[] args) {

		LottoService lottoService = LottoService.init();

		int money = InputView.inputMoney();

		Lottos lottos = lottoService.buyLotto(money);
		ResultView.printBoughtLotto(lottos);

		Lotto winningLotto = lottoService.checkWinningLotto();

		LottoReturns lottoReturns = lottoService.compareWithMyLotto(lottos, winningLotto, money);

		ResultView.printLottoReturns(lottoReturns);

	}
}
