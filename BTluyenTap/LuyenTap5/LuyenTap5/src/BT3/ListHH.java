package BT3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ListHH {
	public boolean equals(ArrayList<QLHH> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (id == list.get(i).getId()) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<QLHH> inputData(ArrayList<QLHH> list) {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		ListHH obj = new ListHH();
		boolean tiepTuc = true;
		boolean tiepTuc1 = true;
		boolean tiepTuc2 = true;
		boolean tiepTuc3 = true;

		do {
			try {
				System.out.println("Số lượng hàng hóa cần nhập: ");
				int n = Integer.parseInt(input.nextLine());
				for (int i = 0; i < n; i++) {
					System.out.println("== NHẬP THÔNG TIN HÀNG HÓA THỨ " + (i + 1) + " ==");

					int id = 0;
					do {
						System.out.println("Nhập vào id: ");
						try {
							int id1 = Integer.parseInt(input.nextLine());
							if (obj.equals(list, id1) == false) {
								id = id1;
								tiepTuc1 = false;
							} else {
								System.out.println("Id bạn vừa nhập đã trùng hãy nhập lại.");
								tiepTuc1 = true;
							}
						} catch (Exception e) {
							System.out.println("Nhập đúng định dạng số");
							tiepTuc1 = true;
						}
					} while (tiepTuc1);

					System.out.println("Nhập vào tên hàng: ");
					String name = input.nextLine();

					int amount = 0;
					do {
						System.out.println("Nhập số lượng: ");
						try {
							int amount1 = Integer.parseInt(input.next());
							amount = amount1;
							tiepTuc2 = false;
						} catch (Exception e) {
							System.out.println("Nhập đúng định dạng.");
							tiepTuc2 = true;
						}
					} while (tiepTuc2);

					float price = 0;
					do {
						System.out.println("Nhập vào giá: ");
						try {
							float price1 = Float.parseFloat(input.next());
							price = price1;
							tiepTuc3 = false;
						} catch (Exception e) {
							System.out.println("Nhập đúng định dạng.");
							tiepTuc3 = true;
						}
					} while (tiepTuc3);
					String dateCreate = sdf.format(date);
					tiepTuc = false;
					list.add(new QLHH(id, name, amount, price, dateCreate));
				}
			} catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
				tiepTuc = true;
			}
		} while (tiepTuc);
		return list;
	}

	public QLHH outputData(ArrayList<QLHH> list) {
		QLHH obj = new QLHH();
		if (list.size() > 0) {
			for (QLHH qlhh : list) {
				System.out.println(qlhh);
			}
		} else {
			System.out.println("Không có hàng hóa nào cả hãy nhập vào.");
		}
		return obj;
	}

	public QLHH searchByName(ArrayList<QLHH> list) {
		ArrayList<QLHH> list1 = new ArrayList<>();
		QLHH obj = new QLHH();
		Scanner input = new Scanner(System.in);
		if (list.size() > 0) {
			System.out.println("Nhập vào tên hàng cần tìm: ");
			String name = input.nextLine();
			for (QLHH qlhh : list) {
				if (qlhh.getName().equals(name)) {
					list1.addAll(list);
				}
			}
			if (list1.size() > 0) {
				System.out.println("Danh sách hàng tìm theo tên: " + name + ": ");
				for (QLHH qlhh : list1) {
					System.out.println(qlhh);
				}
			} else {
				System.out.println("Không có hàng hóa nào với tên '" + name + "' này.");
			}
		} else {
			System.out.println("Không có hàng hóa nào cả.");
		}
		return obj;
	}

	public QLHH deleteByAmount(ArrayList<QLHH> list) {
		QLHH obj1 = new QLHH();
		if (list.size() > 0) {
			list.removeIf(obj -> obj.getAmount() == 0);
		} else {
			System.out.println("Không có hàng hóa nào cả");
		}

		return obj1;
	}

	public static void main(String[] args) {
		ArrayList<QLHH> list = new ArrayList<>();
		ListHH obj = new ListHH();
		Scanner input = new Scanner(System.in);
		boolean tiepTuc = true;
		do {
			System.out.println(
					"Nhập từ 1-5 để:\n--1.Nhập dữ liệu.\n--2.Xuất dữ liệu.\n--3.Tìm hàng hóa theo tên.\n--4.Xóa các hàng có hàng tồn = 0\n--5.Thoát.");
			try {
				int n = Integer.parseInt(input.nextLine());
				switch (n) {
				case 1:
					inputData(list);
					break;
				case 2:
					System.out.println("Danh sách hàng hóa: ");
					obj.outputData(list);
					break;
				case 3:

					obj.searchByName(list);
					break;
				case 4:
					System.out.println("Danh sách hàng sau khi xóa: ");
					obj.deleteByAmount(list);
					obj.outputData(list);
					break;
				case 5:
					System.out.println("Goobye!");
					tiepTuc = false;
					break;

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Hãy nhập đúng định dạng số.");
				tiepTuc = true;
			}

		} while (tiepTuc);
	}
}
