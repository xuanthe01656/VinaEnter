package news;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ListNews {
	public boolean formatDate(String date) {
		LocalDate localDate = LocalDate.now();
		int nowYear = localDate.getYear();
		String[] str = date.split("/");
		String dd = str[0];
		String mm = str[1];
		String yyyy = str[2];
		int day = Integer.parseInt(dd);
		int month = Integer.parseInt(mm);
		int year = Integer.parseInt(yyyy);
		if (day > 0 && day <= 31 && month > 0 && month != 2 && month <= 12 && year>1000 && year <= nowYear ) {
			return true;
		} else {
			if (day > 0 && day <= 29 && month == 2 && year>1000 && year <= nowYear) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<News> inputData(ArrayList<News> list) {
		ListNews obj = new ListNews();
		Scanner input = new Scanner(System.in);
		boolean tiepTuc = true;
		boolean tiepTuc1 = true;
		boolean tiepTuc2 = true;
		boolean tiepTuc3 = true;
		do {
			try {
				System.out.println("== NHẬP VÀO THÔNG TIN CỦA TIN TỨC ==");
				System.out.println("Số tin tức cần nhập: ");
				int n = Integer.parseInt(input.nextLine());
				for (int i = 0; i < n; i++) {
					System.out.println("Nhập vào thông tin của tin thứ " + (i + 1) + ": ");
					int idNews = 0;
					do {
						System.out.println("Nhập vào ID của tin: ");
						try {
							int idNews1 = Integer.parseInt(input.nextLine());
							if(obj.equals(list, idNews1)==false) {
								idNews = idNews1;
								tiepTuc2 = false;
							}else {
								System.out.println("ID bạn vừa nhập đã tồn tại nhập lại ID khác.");
								tiepTuc2=true;
							}
							
						} catch (Exception e) {
							System.out.println("Hãy nhập đúng định dạng số: ");
							tiepTuc2 = true;
						}
					} while (tiepTuc2);
					System.out.println("Nhập vào tên tin: ");
					String name = input.nextLine();
						
					int count_number = 0;
					do {
						System.out.println("Nhập vào lượt xem: ");
						try {
							int count_number1 = Integer.parseInt(input.nextLine());
							count_number = count_number1;
							tiepTuc3 = false;
						} catch (Exception e) {
							System.out.println("Hãy nhập đúng định dạng số: ");
							tiepTuc3 = true;
						}
					} while (tiepTuc3);

					String created_at = "";
					do {
						System.out.println("Nhập vào ngày sản xuất: ");
						try {
							String created_date = input.nextLine();
							if (obj.formatDate(created_date) == true) {
								created_at = created_date;
								tiepTuc1 = false;
							} else {
								System.out.println("Kiểm tra lại ngày tháng năm.");
								tiepTuc1 = true;
							}
						} catch (Exception e) {
							System.out.println("Hãy nhập đúng định dạng dd/mm/yyyy");
							tiepTuc1 = true;
						}
					} while (tiepTuc1);
					tiepTuc = false;
					list.add(new News(idNews, name, count_number, created_at));
				}
			} catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
				tiepTuc = true;
			}
		} while (tiepTuc);
		return list;
	}

	public News outputData(ArrayList<News> list) {
		News obj = new News();
		if (list.size() > 0) {
			for (News news : list) {
				System.out.println(news);
			}
		} else {
			System.out.println("Không có tin nào cả hãy nhập tin vào: ");
		}
		return obj;
	}

	public News searchByIdNews(ArrayList<News> list) {
		News obj = new News();
		ArrayList<News> list1 = new ArrayList<>();
		boolean tiepTuc = true;
		Scanner input = new Scanner(System.in);
		do {
			try {
				if (list.size() > 0) {
					System.out.println("Nhập vào id tin muốn tìm: ");
					int idNews = Integer.parseInt(input.nextLine());
					for (News news : list) {
						if (idNews == news.getIdNews()) {
							list1.add(news);
						}
					}
					if (list1.size() > 0) {
						for (News news : list1) {
							System.out.println(news);
						}
					} else {
						System.out.println("Không có tin với ID '" + idNews + "' này");
					}
				} else {
					System.out.println("Không có tin tức.");
				}
				tiepTuc = false;
			} catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
			}
		} while (tiepTuc);

		return obj;
	}

	public News searchByname(ArrayList<News> list) {
		News obj = new News();
		ArrayList<News> list1 = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		if (list.size() > 0) {
			System.out.println("Nhập vào tên muốn tìm: ");
			String name = input.nextLine();
			for (News news : list) {
				if (name.equals(news.getName())) {
					list1.add(news);
				}
			}
			if (list1.size() > 0) {
				for (News news : list1) {
					System.out.println("Tin bạn tìm với tên '" + name + "' là:\n" + news);
				}
			} else {
				System.out.println("Không có tin với tên '" + name + "' này");
			}
		} else {
			System.out.println("Không có tin tức nào cả.");
		}
		return obj;
	}

	public News searchCountNumberMax(ArrayList<News> list) {
		News obj = new News();
		ArrayList<News> list1 = new ArrayList<>();
		if (list.size() > 0) {
			int max = list.get(0).getCount_number();
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getCount_number() > max) {
					max = list.get(i).getCount_number();
				}
			}
			for (News news : list) {
				if (news.getCount_number() == max) {
					list1.add(news);
				}
			}
			for (News news : list1) {
				System.out.println(news + "\nSố lượng đọc là: " + news.getCount_number());
			}
		} else {
			System.out.println("Không có tin nào cả.");
		}
		return obj;
	}

	public News outputIdNewsEven(ArrayList<News> list) {
		ArrayList<News> list1 = new ArrayList<>();
		News obj = new News();
		if (list.size() > 0) {
			for (News news : list) {
				if (news.getIdNews() % 2 == 0) {
					list1.add(news);
				}
			}
			if (list1.size() > 0) {
				for (News news : list1) {
					System.out.println(news);
				}
			}
		} else {
			System.out.println("Không có tin nào cả.");
		}
		return obj;
	}
	public News deleteByIdNews(ArrayList<News> list) {
		News obj1 = new News();
		Scanner input = new Scanner(System.in);
		if(list.size()>0) {
			System.out.println("Nhập ID tin cần xóa.");
			int n = Integer.parseInt(input.nextLine());
			list.removeIf(obj -> (obj.getIdNews()==n));
		}else {
			System.out.println("Không có tin tức nào cả.");
		}
		
		return obj1;
	}

	public boolean equals(ArrayList<News> list, int idNews) {
		for (int i = 0; i < list.size(); i++) {
			if (idNews==(list.get(i).getIdNews())) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<News> list = new ArrayList<>();
		ListNews obj = new ListNews();
		Scanner input = new Scanner(System.in);
		boolean tiepTuc = true;
		do {
			System.out.println("Nhập vào số từ 1-8 để:\n--1.Nhập dữ liệu.\n--2.Xuất dữ liệu.\n--3.Tìm News theo newsID.\n--4.Tìm News theo name.\n--5.Tìm News theo có Lượt đọc cao nhất.\n--6.Xuất dữ liệu News có newsID chẵn.\n--7.Xóa news theo ID tin.\n--8.Thoát.");
			try {
				int n = Integer.parseInt(input.nextLine());
				switch (n) {
				case 1:
					inputData(list);
					break;
				case 2:
					System.out.println("Danh sách các tin:");
					obj.outputData(list);
					break;
				case 3:
					System.out.println("Danh sách tin có ID muốn tìm là: ");
					obj.searchByIdNews(list);
					
					break;
				case 4:
					obj.searchByname(list);
					break;
				case 5:
					System.out.println("Danh sách tin có số lượng đọc cao nhất là: ");
					obj.searchCountNumberMax(list);
					break;
				case 6:
					System.out.println("Danh sách các tin có ID chẵn là:");
					obj.outputIdNewsEven(list);
					break;
				case 7:
					obj.deleteByIdNews(list);
					System.out.println("Danh sách tin sau khi xóa là: ");
					obj.outputData(list);
					break;
				case 8:
					System.out.println("Goobye!");
					tiepTuc = false;
					break;
				default:
					System.out.println("Nhập vào số từ 1-7");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Hãy nhập đúng định dạng");
			}
		} while (tiepTuc);
	}
}
