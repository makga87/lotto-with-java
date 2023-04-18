package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoReturns {

	private Map<WinningsTable, Integer> lottoReturnsStatus;

	private LottoReturns(Map<WinningsTable, Integer> lottoReturnsStatus) {
		this.lottoReturnsStatus = lottoReturnsStatus;
	}

	public static LottoReturns init() {
		Map<WinningsTable, Integer> lottoReturnsStatus = new HashMap<>();
		lottoReturnsStatus.put(WinningsTable.FORTH_PLACE, 0);
		lottoReturnsStatus.put(WinningsTable.THIRD_PLACE, 0);
		lottoReturnsStatus.put(WinningsTable.SECOND_PLACE, 0);
		lottoReturnsStatus.put(WinningsTable.FIRST_PLACE, 0);

		return new LottoReturns(lottoReturnsStatus);
	}

	public void countPlusReturns(WinningsTable winningsTable) {
		if (lottoReturnsStatus.containsKey(winningsTable)) {
			lottoReturnsStatus.put(winningsTable, lottoReturnsStatus.get(winningsTable) + 1);
		}
	}

	public int getCount(WinningsTable winningsTable) {
		if (lottoReturnsStatus.containsKey(winningsTable)) {
			return lottoReturnsStatus.get(winningsTable);
		}
		return 0;
	}
}
