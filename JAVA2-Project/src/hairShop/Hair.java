package hairShop;

import java.util.Scanner;

import mgr.Manageable;

public class Hair implements Manageable {
	private String name; // PR KEY(�ߺ���������)
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
			System.out.println("�޴��̸� : " + name);
			System.out.println("���� : " + price);
			System.out.println("�Ⱓ : " + (span * 30) + "��");
			if (gender == 1)
				System.out.println("(�����޴�)");
			else
				System.out.println("(�����޴�)");
			System.out.println();
		}else {
			System.out.println("�޴��̸� : " + name);
			System.out.println("���� : " + price);
			System.out.println();
		}
		
	}

	@Override
	public void print() {
		print(true);

	}

}