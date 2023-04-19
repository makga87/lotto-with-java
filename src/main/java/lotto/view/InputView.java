package lotto.view;

import java.util.Scanner;

public class InputView {

	private static Scanner scanner = new Scanner(System.in);

	private static int LOTTO_PRICE = 1000;

	public static int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String money = scanner.next();
		System.out.println(money);
		int count = Integer.parseInt(money) / LOTTO_PRICE;
		System.out.println(count + "개를 구매했습니다.");
		return count;
	}

	public static String inputWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.next();
	}
}
