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
			System.out.println("�����̳� ���̵�: " + id);
			System.out.println("�����̳� �̸�: " + name);
			System.out.println("���� ���� �� : " + reservationList.size());
			System.out.println("�ü� ���� �޴� ��: " + hairList.size());
			System.out.println();

		}else {
			System.out.println("�����̳� ���̵�: " + id);
			System.out.println("�����̳� �̸�: " + name);
			System.out.println();
		}

	}

}