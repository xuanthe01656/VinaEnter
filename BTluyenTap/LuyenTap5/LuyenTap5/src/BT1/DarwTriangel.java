package BT1;

import java.util.Scanner;

public class DarwTriangel {
	public void draw() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào chiều cao: ");
		int h = Integer.parseInt(input.nextLine());
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= i; j++) {
				if(i==1 || j==i ||j==1|| i==h || j==h) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		DarwTriangel obj = new DarwTriangel();
		obj.draw();
	}
}
