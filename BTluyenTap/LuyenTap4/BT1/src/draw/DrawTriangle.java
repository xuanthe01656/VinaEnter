package draw;

import java.util.Scanner;

public class DrawTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean tiepTuc = true;
		do {
			try {
				System.out.printf("Nhập vào chiều cao: ");
				int h = Integer.parseInt(input.nextLine());
				int k = 0;
				if (h > 3 && h < 20) {
					for (int i = 1; i <= h; i++, k = 0) {
						for (int j = 1; j <= h - i; j++) {
							System.out.print("  ");
						}
						while (k != 2 * i - 1) {
							System.out.print((k + 1) + " ");
							++k;
						}
						System.out.println();
					}
					tiepTuc = false;
				} else {
					System.out.println("Nhập số nằm trong khoảng từ 4-19");
				}
			} catch (Exception e) {
				System.out.println("Hãy nhập đúng định dạng số");
			}
		} while (tiepTuc);

	}
}
