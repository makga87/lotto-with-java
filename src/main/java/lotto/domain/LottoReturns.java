package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoReturns {

	private Map<WinningsTable, Integer> lottoReturnsStatus;
	private int money;

	private LottoReturns(Map<WinningsTable, Integer> lottoReturnsStatus, int money) {
		this.lottoReturnsStatus = lottoReturnsStatus;
		this.money = money;
	}

	public static LottoReturns from(int money) {
		Map<WinningsTable, Integer> lottoReturnsStatus = new HashMap<>();
		lottoReturnsStatus.put(WinningsTable.FORTH_PLACE, 0);
		lottoReturnsStatus.put(WinningsTable.THIRD_PLACE, 0);
		lottoReturnsStatus.put(WinningsTable.SECOND_PLACE, 0);
		lottoReturnsStatus.put(WinningsTable.FIRST_PLACE, 0);

		return new LottoReturns(lottoReturnsStatus, money);
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

	public Map<WinningsTable, Integer> getLottoReturnsStatus() {
		return Collections.unmodifiableMap(lottoReturnsStatus);
	}

	public double getReturns() {
		int totalReturns = lottoReturnsStatus.entrySet()
											 .stream()
											 .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
											 .sum();

		return Math.floor((totalReturns / (double) money) * 100) / 100;
	}
}
