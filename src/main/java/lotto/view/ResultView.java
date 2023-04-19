package lotto.view;

import java.util.Map;
import java.util.Scanner;

import lotto.domain.LottoReturns;
import lotto.domain.Lottos;
import lotto.domain.WinningsTable;

public class ResultView {

	private static Scanner scanner = new Scanner(System.in);

	public static void printBoughtLotto(Lottos lottos) {
		lottos.getLottos()
			  .forEach(lotto -> {
				  System.out.println(lotto.toString());
			  });
	}

	public static void printLottoReturns(LottoReturns lottoReturns) {

		Map<WinningsTable, Integer> lottoReturnsStatus = lottoReturns.getLottoReturnsStatus();
		lottoReturnsStatus.entrySet()
						  .stream()
						  .forEach(entry -> {
							  WinningsTable winningsTable = entry.getKey();
							  int matchingCount = entry.getValue();

							  String status = String.format("%d개 일치 (%d원) - %d", winningsTable.getMatchingCount(), winningsTable.getMoney(),
															matchingCount);
							  System.out.println(status);
						  });

		System.out.println(String.format("총 수익률은 %.2f입니다.", lottoReturns.getReturns()));
	}
}
