package baitap1;

import java.util.Scanner;

public class Draw {
	public static void draw(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 0;
		boolean tiepTuc = true;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Nhập vào độ cao: ");
			try {
				n = Integer.parseInt(input.nextLine());
				tiepTuc = false;
			} catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
				tiepTuc = true;
			}
		} while (tiepTuc);		
		draw(n);
		
	}
}
