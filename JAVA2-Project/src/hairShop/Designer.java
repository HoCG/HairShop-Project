package hairShop;

import hairShop.*;
import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

public class Designer implements Manageable {
	private ArrayList<Hair> hairList = new ArrayList<>();
	private ArrayList<Reservation> reservationList = new ArrayList<>();
	private String name;
	private String id;

	@Override
	public void read(Scanner scan) {
		String[] inputLine = scan.nextLine().split("/");
		this.id = inputLine[0];
		this.name = inputLine[1];
		String hairLine[] = inputLine[2].split("#");
		for (String key : hairLine) {
			hairList.add((Hair) HairShop.hairMgr.find(key));
		}
		this.getReservationList();
	}
	

	public void getReservationList() {
		ArrayList<Manageable> list = HairShop.reservationMgr.findAll(this.id);

		for (Manageable i : list) {
			reservationList.add((Reservation) i );
		}
	}

	@Override
	public void print() {
		print(true);

	}

	@Override
	public boolean matches(String kwd) {
		if (kwd.equals("" + name))
			return true;
		if (kwd.equals("" + id))
			return true;
		return false;
	}

	@Override
	public void print(boolean bDetail) {
		if(bDetail) {
			System.out.println("디자이너 아이디: " + id);
			System.out.println("디자이너 이름: " + name);
			System.out.println("현재 예약 수 : " + reservationList.size());
			System.out.println("시술 가능 메뉴 수: " + hairList.size());
			System.out.println();

		}else {
			System.out.println("디자이너 아이디: " + id);
			System.out.println("디자이너 이름: " + name);
			System.out.println();
		}

	}

}