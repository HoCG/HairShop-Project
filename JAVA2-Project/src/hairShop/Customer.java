package hairShop;

import hairShop.*;
import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

public class Customer implements Manageable {

	private String id;
	private String name;
	private String level;
	private int point;
	private int gender;
	private ArrayList<Reservation> reservationList = new ArrayList<>();

	@Override
	public void read(Scanner scan) {

		String[] inputLine = scan.nextLine().split("/");
		this.id = inputLine[0];
		this.name = inputLine[1];
		this.level = inputLine[2];
		this.point = Integer.parseInt(inputLine[3]);
		this.gender = Integer.parseInt(inputLine[4]);
		this.getReservationList();
	}

	public void getReservationList() {
		ArrayList<Manageable> list = HairShop.reservationMgr.findAll(this.id);

		for (Manageable i : list) {
			reservationList.add((Reservation) i);
		}
	}
	
	@Override
	public boolean matches(String kwd) {
		if (kwd.equals("" + id))
			return true;
		if (kwd.equals("" + name))
			return true;
		if (kwd.equals("" + level))
			return true;
		return false;
	}


	@Override
	public void print() {
		print(true);
	}


	@Override
	public void print(boolean bDetail) {
		if(bDetail) {
			System.out.println("�� ���̵�: " + id);
			System.out.println("�̸� " + name);
			System.out.println("��� : " + level);
			System.out.println("�ܿ� ����Ʈ : " + point);
			if (gender == 1)
				System.out.println("(����)");
			else
				System.out.println("(����)");
			System.out.println("���� ���� �� : " + reservationList.size());
			System.out.println();
		}else {
			System.out.println("�� ���̵�: " + id);
			System.out.println("�̸� " + name);
			System.out.println();
		}

	}

}
