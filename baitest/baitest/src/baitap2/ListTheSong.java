package baitap2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ListTheSong {
	public static ArrayList<TheSong> inputData(ArrayList<TheSong> list) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = new Date();
		Scanner input = new Scanner(System.in);
		int n = 0;
		int id = 0;
		String name;
		String date_creat;
		int view = 0;
		boolean tiepTuc = true;
		System.out.println("== NHẬP THÔNG TIN BÀI HÁT ==");
		do {
			System.out.println("Số bài hát cần nhập: ");
			try {
				n = Integer.parseInt(input.nextLine());
				tiepTuc = false;
			} catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
				tiepTuc = true;
			}
		} while (tiepTuc);
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin thứ " + (i + 1) + ": ");
			do {
				System.out.println("Nhập id bài hát: ");
				try {
					id = Integer.parseInt(input.nextLine());
					tiepTuc = false;
				} catch (Exception e) {
					System.out.println("Nhập đúng định dạng số.");
					tiepTuc = true;
				}
			} while (tiepTuc);
			System.out.println("Nhập tên bài hát: ");
			name = input.nextLine();
			date_creat = sdf.format(date);
			do {
				System.out.println("Nhập vào số lượt xem: ");
				try {
					view = Integer.parseInt(input.nextLine());
					tiepTuc = false;
				} catch (Exception e) {
					System.out.println("Nhập đúng định dạng số.");
					tiepTuc = true;
				}

			} while (tiepTuc);

			list.add(new TheSong(id, name, date_creat, view));
		}
		return list;
	}

	public void outputData(ArrayList<TheSong> list) {
		if (list.size() > 0) {
			for (TheSong theSong : list) {
				System.out.println(theSong);
			}
		} else {
			System.out.println("Không có bài hát nào cả.");
		}
	}

	public static ArrayList<TheSong> searchById(ArrayList<TheSong> list) {
		ArrayList<TheSong> list1 = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int id = 0;
		boolean tiepTuc = true;
		if(list.size()>0) {
			do {
				System.out.println("Nhập vào ID: ");
				try {
					id = Integer.parseInt(input.nextLine());
					for (TheSong theSong : list) {
						if (id == theSong.getId()) {
							list1.add(theSong);
							tiepTuc = false;
						}
					}
				} catch (Exception e) {
					System.out.println("Nhập đúng định dạng số.");
				}

			} while (tiepTuc);
		}else {
			System.out.println("Không có bài hát nào cả.");
		}
		return list1;
	}

	public static ArrayList<TheSong> searchByName(ArrayList<TheSong> list) {
		ArrayList<TheSong> list1 = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		String name;
		if(list.size()>0) {
			System.out.println("Nhập vào tên bài hát cần tìm: ");
			name = input.nextLine();
			for (TheSong theSong : list) {
				if (name.equalsIgnoreCase(theSong.getName())) {
					list1.add(theSong);
				}
			}
		}else {
			System.out.println("Không có bài hát nào cả.");
		}
		
		return list1;
	}
	public static void menuTheSong() {
		ArrayList<TheSong> list = new ArrayList<>();
		ArrayList<TheSong> listSearchById = new ArrayList<>();
		ArrayList<TheSong> listSearchbyName = new ArrayList<>();
		ListTheSong obj = new ListTheSong();
		Scanner input = new Scanner(System.in);
		int n = 0;
		boolean tiepTuc = true;
		do {
			System.out.println("Nhập từ 1-5 để:\n--1. Nhập dữ liệu.\n--2. Xuất dữ liệu.\n--3. Tìm bài hát theo ID.\n--4. Tìm bài hát theo tên.\n--5. Thoát.");
			try {
				n = Integer.parseInt(input.nextLine());
				switch (n) {
				case 1:
					inputData(list);
					break;
				case 2:
					System.out.println("Danh sách các bài hát: ");
					obj.outputData(list);
					break;
				case 3:
					listSearchById = searchById(list);
					System.out.println("Danh sách tìm theo ID: ");
					for (TheSong theSong : listSearchById) {
						System.out.println(theSong);
					}
					break;
				case 4:
					listSearchbyName = searchByName(list);
					System.out.println("Danh sách tìm theo name: ");
					for (TheSong theSong : listSearchbyName) {
						System.out.println(theSong);
					}
					break;
				case 5:
					System.out.println("Goodbye!");
					tiepTuc = false;
					break;

				default:
					System.out.println("Nhập số từ 1-5");
					break;
				}
			} catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
			}
		} while (tiepTuc);
	}

	public static void main(String[] args) {
		menuTheSong();
	}
}
