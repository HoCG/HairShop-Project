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
		readAll(); //���ϸ���
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
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}
	
	private void startMessage() {
		System.out.println("------------------ �̿�� ���� �ý��� ver 1.0 -------------------");
		System.out.println("|	��ü�������α׷��� �����567                                     |");
		System.out.println("|	�ָԱ���(9��)                                               |");
		System.out.println("|                                                            |");
		System.out.println("|	����: ���±�                                                                                                         |");
		System.out.println("|	����: �ӿ���                                                                                                         |");
		System.out.println("|	����: ���¿�                                                                                                         |");
		System.out.println("|	����: Ȳȣ��                                                                                                         |");
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------");
	}
	
	private void menu() { //���θ޴�
		System.out.println("-���θ޴�-");
		System.out.println("1. ��ȸ");
		System.out.println("2. ���� //�̱���");
		System.out.println("3. �߰� //�̱���");
		System.out.println("4. ���� //�̱���");
		System.out.println("0. ���� //�̱���");
		System.out.print("-> ");
	}
	
	private void menu1() { //��ȸ���
		
		Scanner scan = new Scanner(System.in);
		System.out.println("- 1. ��ȸ -");
		System.out.println("1. �� ��ȸ");
		System.out.println("2. ���� ��ȸ");
		System.out.println("3. �޴� ��ȸ");
		System.out.println("4. ���� ��ȸ");
		System.out.println("0. �ڷ� ����");
		System.out.print(">> ");
		
		int input = scan.nextInt();
		switch (input+"") {
		case "1":
			//customerMgr.printAll(false); ��ü ����Ʈ��->��ġ �ҰŸ� ���, ��ġ�� �����ҽ� �ּ����� ����
			customerMgr.search(scan);
			break;
		case "2":
			//reservationMgr.printAll(false); ��ü ����Ʈ��->��ġ �ҰŸ� ���, ��ġ�� �����ҽ� �ּ����� ����
			reservationMgr.search(scan);
			break;
		case "3":
			//hairMgr.printAll(false); ��ü ����Ʈ��->��ġ �ҰŸ� ���, ��ġ�� �����ҽ� �ּ����� ����
			hairMgr.search(scan);
			break;
		case "4":
			//designerMgr.printAll(false); ��ü ����Ʈ��->��ġ �ҰŸ� ���, ��ġ�� �����ҽ� �ּ����� ����
			designerMgr.search(scan);
			break;
		case "0":
			return;
		default:
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			break;
		}
	}
	
	private void menu2() { //������
		
	}
	
	private void menu3() { //�߰����

	}
	
	private void menu4() { //�������
		
	}
	
	private void printAll() {
		System.out.println("----------���޴�----------");
		hairMgr.printAll();

		System.out.println("----------��������----------");
		reservationMgr.printAll();
		
		System.out.println("----------������----------");
		customerMgr.printAll();
		
		System.out.println("----------��������----------");
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
