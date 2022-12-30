package draw;

import java.util.Scanner;

public class DrawRec {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào chiều cao của tam giác: ");
		int h = Integer.parseInt(input.nextLine());
		for (int i = 1; i <= h * 2 - 1; i++) {
			for (int j = 1; j <= h * 2 - 1; j++) {
				int min = Math.min(Math.min(i-1, h*2-1-i), Math.min(j-1,  h*2-1-j));
				System.out.print(1+min);
			}
			System.out.println();
		}
	}
}
