package hairShop;

import java.util.Scanner;

import mgr.Manageable;

public class Hair implements Manageable {
	private String name; // PR KEY(중복하지말것)
	private int price;
	private int span;
	private int gender;

	@Override
	public void read(Scanner scan) {

		String[] inputLine = scan.nextLine().split("/");
		this.name = inputLine[0];
		this.price = Integer.parseInt(inputLine[1]);
		this.span = Integer.parseInt(inputLine[2]);
		this.gender = Integer.parseInt(inputLine[3]);
	}

	@Override
	public boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.equals("" + price))
			return true;
		if (kwd.equals("" + span))
			return true;
		return false;
	}

	@Override
	public void print(boolean bDetail) {
		if(bDetail) {
			System.out.println("메뉴이름 : " + name);
			System.out.println("가격 : " + price);
			System.out.println("기간 : " + (span * 30) + "분");
			if (gender == 1)
				System.out.println("(남성메뉴)");
			else
				System.out.println("(여성메뉴)");
			System.out.println();
		}else {
			System.out.println("메뉴이름 : " + name);
			System.out.println("가격 : " + price);
			System.out.println();
		}
		
	}

	@Override
	public void print() {
		print(true);

	}

}