package hairShop;
import java.util.Scanner;

import mgr.*;


public class HairShop{
	static Manager hairMgr = new Manager();
	static Manager customerMgr = new Manager();
	static Manager designerMgr = new Manager();
	static Manager reservationMgr = new Manager();
	
	public static void main(String[] args) {
		HairShop hairShop = new HairShop();
		hairShop.run();
	}

	public void run() {
		readAll(); //파일리딩
		runMenu();
	}
	
	void runMenu() {
		startMessage();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			menu();
			String input = scan.next();
			switch (input+"") {
			case "1":
				menu1();
				break;
			case "2":
				menu2();
				break;
			case "3":
				menu3();
				break;
			case "4":
				menu4();
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 값을 입력하셨습니다.");
				break;
			}
		}
	}
	
	private void startMessage() {
		System.out.println("------------------ 미용실 관리 시스템 ver 1.0 -------------------");
		System.out.println("|	객체지향프로그래밍 목요일567                                     |");
		System.out.println("|	주먹구구(9조)                                               |");
		System.out.println("|                                                            |");
		System.out.println("|	조장: 유태근                                                                                                         |");
		System.out.println("|	조원: 임예광                                                                                                         |");
		System.out.println("|	조원: 엄승열                                                                                                         |");
		System.out.println("|	조원: 황호세                                                                                                         |");
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------");
	}
	
	private void menu() { //메인메뉴
		System.out.println("-메인메뉴-");
		System.out.println("1. 조회");
		System.out.println("2. 예약 //미구현");
		System.out.println("3. 추가 //미구현");
		System.out.println("4. 수정 //미구현");
		System.out.println("0. 종료 //미구현");
		System.out.print("-> ");
	}
	
	private void menu1() { //조회기능
		
		Scanner scan = new Scanner(System.in);
		System.out.println("- 1. 조회 -");
		System.out.println("1. 고객 조회");
		System.out.println("2. 예약 조회");
		System.out.println("3. 메뉴 조회");
		System.out.println("4. 직원 조회");
		System.out.println("0. 뒤로 가기");
		System.out.print(">> ");
		
		int input = scan.nextInt();
		switch (input+"") {
		case "1":
			//customerMgr.printAll(false); 전체 리스트업->서치 할거면 사용, 서치만 지원할시 주석으로 유지
			customerMgr.search(scan);
			break;
		case "2":
			//reservationMgr.printAll(false); 전체 리스트업->서치 할거면 사용, 서치만 지원할시 주석으로 유지
			reservationMgr.search(scan);
			break;
		case "3":
			//hairMgr.printAll(false); 전체 리스트업->서치 할거면 사용, 서치만 지원할시 주석으로 유지
			hairMgr.search(scan);
			break;
		case "4":
			//designerMgr.printAll(false); 전체 리스트업->서치 할거면 사용, 서치만 지원할시 주석으로 유지
			designerMgr.search(scan);
			break;
		case "0":
			return;
		default:
			System.out.println("잘못된 값을 입력하셨습니다.");
			break;
		}
	}
	
	private void menu2() { //예약기능
		
	}
	
	private void menu3() { //추가기능

	}
	
	private void menu4() { //수정기능
		
	}
	
	private void printAll() {
		System.out.println("----------헤어메뉴----------");
		hairMgr.printAll();

		System.out.println("----------예약정보----------");
		reservationMgr.printAll();
		
		System.out.println("----------고객정보----------");
		customerMgr.printAll();
		
		System.out.println("----------직원정보----------");
		designerMgr.printAll();
	}
	
	private void readAll() {
		hairMgr.readAll("hairs.txt", new Factory() {
			public Manageable create() {
				return new Hair();
			}
		});
		reservationMgr.readAll("reservations.txt", new Factory() {
			public Manageable create() {
				return new Reservation();
			}
		});
		customerMgr.readAll("customers.txt", new Factory() {
			public Manageable create() {
				return new Customer();
			}
		});
		designerMgr.readAll("designers.txt", new Factory() {
			public Manageable create() {
				return new Designer();
			}
		});
	}


}
