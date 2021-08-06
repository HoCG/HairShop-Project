package hairShop;

import java.util.Scanner;
import hairShop.*;

import mgr.Manageable;

public class Reservation implements Manageable {
	private String customerId;
	private String date;
	private String designerId;
	private String hairName;
	private Hair hair;

	@Override
	public void read(Scanner scan) {

		String[] inputLine = scan.nextLine().split("/");
		this.customerId = inputLine[0];
		this.date = inputLine[1];
		this.designerId = inputLine[2];
		this.hairName = inputLine[3];
		hair = (Hair) HairShop.hairMgr.find(hairName);
	}

	@Override
	public void print() {
		print(true);

	}

	@Override
	public boolean matches(String kwd) {
		if (kwd.equals("" + customerId))
			return true;
		if (date.contains(kwd))
			return true;
		if (kwd.equals("" + designerId))
			return true;
		if (hairName.contains(kwd))
			return true;
		return false;
	}

	@Override
	public void print(boolean bDetail) {
		if(bDetail) {
			System.out.println("�� ���̵�: " + customerId);
			System.out.println("�����̳� ���̵�: " + designerId);
			System.out.println("���೯¥ : " + date);
			System.out.println("�޴��� : " + hairName);
			System.out.println();
		}else {
			System.out.println("�� ���̵�: " + customerId);
			System.out.println("���೯¥ : " + date);
			System.out.println();
		}
	}

}