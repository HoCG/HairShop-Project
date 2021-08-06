package mgr;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	public ArrayList<Manageable> mList = new ArrayList<>();
	
	public Manageable find(String kwd) {
	    for (Manageable m: mList)
	    	if (m.matches(kwd))
	    		return m;
	    return null;
	}
	
	public ArrayList<Manageable> findAll(String kwd) {
	    ArrayList<Manageable> findList = new ArrayList<>();
		for (Manageable m: mList)
	    	if (m.matches(kwd))
	    		findList.add(m);
	    return findList;
	}
	
	
	public void readAll(String filename, Factory fac) {
		
		Scanner filein = openFile(filename);
		//filein.nextLine(); // 첫번째줄 처리
		
		Manageable m = null;
		while (filein.hasNextLine()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	public void printAll() {
		for (Manageable m : mList) {	
			m.print();
		}
	}
	
	public void printAll(boolean bDetail) {
		int count = 0;
		for (Manageable m : mList) {	
			System.out.println(count + ":");
			m.print(bDetail);
			count++;
		}
	}
	public void search(Scanner keyScanner) {
		String kwd = null;
		System.out.println("검색 (end 입력시 종료)" );
		while (true) {
			System.out.print(">> ");
			kwd = keyScanner.next();
			if (kwd.equals("end"))
				break;
			for (Manageable m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}
	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(filename + ": 파일 없음");
			System.exit(0);
		}
		return filein;
	}
}