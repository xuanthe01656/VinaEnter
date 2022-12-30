package BT2;

import java.util.Scanner;

public class SumInt {
	public int sum() {
		Scanner input = new Scanner(System.in);
		int d;
		int sum=0;
		boolean tiepTuc = true;
		do {
			System.out.println("Nhập vào một dãy số nguyên: ");
			try {
				int n = Integer.parseInt(input.nextLine());
				while(n>0) {
					//tách lấy số cuối trong dãy.
					d = n%10;
					sum+=d;
					//bỏ đi số đã lấy.
					n = n/10;
				}
				tiepTuc = false;
			}catch (Exception e) {
				System.out.println("Nhập đúng định dạng số.");
				tiepTuc = true;
			}
		}while(tiepTuc);
		return sum;
	}
	public static void main(String[] args) {
		SumInt obj =  new SumInt();
		int sum = obj.sum();
		System.out.println("Tổng của dãy số vừa nhập là: "+sum);
	}
}
