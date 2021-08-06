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
			System.out.println("고객 아이디: " + id);
			System.out.println("이름 " + name);
			System.out.println("등급 : " + level);
			System.out.println("잔여 포인트 : " + point);
			if (gender == 1)
				System.out.println("(남성)");
			else
				System.out.println("(여성)");
			System.out.println("현재 예약 수 : " + reservationList.size());
			System.out.println();
		}else {
			System.out.println("고객 아이디: " + id);
			System.out.println("이름 " + name);
			System.out.println();
		}

	}

}
