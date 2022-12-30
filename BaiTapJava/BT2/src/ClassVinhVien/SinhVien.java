package ClassVinhVien;

import java.util.Scanner;

public class SinhVien {
	private int MaSV;
	private String TenSV;
	private float DiemToan;
	private float DiemTin;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int maSV, String tenSV, float diemToan, float diemTin) {
		super();
		MaSV = maSV;
		TenSV = tenSV;
		DiemToan = diemToan;
		DiemTin = diemTin;
	}

	public int getMaSV() {
		return MaSV;
	}

	public void setMaSV(int maSV) {
		MaSV = maSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public float getDiemToan() {
		return DiemToan;
	}

	public void setDiemToan(float diemToan) {
		DiemToan = diemToan;
	}

	public float getDiemTin() {
		return DiemTin;
	}

	public void setDiemTin(float diemTin) {
		DiemTin = diemTin;
	}

	public SinhVien setSV() {
		Scanner input = new Scanner(System.in);
		System.out.println("==NHẬP VÀO THÔNG TIN HỌC VIÊN==");
		boolean tiepTuc2 = true;
		boolean tiepTuc3 = true;
		System.out.println("Nhập vào mã sinh viên đúng theo định dạng số");
		int MaSV = Integer.parseInt(input.nextLine());
		System.out.println("Nhập vào tên sinh viên: ");
		String TenSV = input.nextLine();
		float DiemToan = 0;
		while (tiepTuc2) {
			System.out.println("Nhập vào điểm toán:");
			float DiemToan1 = Float.parseFloat(input.nextLine());
			if (DiemToan1 >= 0 && DiemToan1 <= 10) {
				DiemToan = DiemToan1;
				tiepTuc2 = false;
			} else {
				System.out.println("Hãy nhập trong khoảng từ 0-10.");
			}
		}
		float DiemTin = 0;
		while (tiepTuc3) {
			System.out.println("Nhập vào điểm tin:");
			float DiemTin1 = Float.parseFloat(input.nextLine());
			if (DiemTin1 >= 0 && DiemTin1 <= 10) {
				DiemTin = DiemTin1;
				tiepTuc3 = false;
			} else {
				System.out.println("Hãy nhập trong khoảng từ 0-10.");
			}
		}
		SinhVien obj = new SinhVien(MaSV, TenSV, DiemToan, DiemTin);
		return obj;
	}

	public String viewSV() {
		return "Mã Sinh Viên: " + this.MaSV + "\nTên Sinh Viên: " + this.TenSV + "\nĐiểm Toán: " + this.DiemToan
				+ "\nĐiểm Tin: " + this.DiemTin + "\nTổng Điểm: " + this.tongdiem();
	}

	public float tongdiem() {
		float DiemToan = this.DiemToan;
		float DiemTin = this.DiemTin;
		float sum = DiemToan + DiemTin;
		return sum;
	}

	public SinhVien findSinhVien(SinhVien toan1, SinhVien toan2) {
		float DiemToan1 = toan1.getDiemToan();
		float DiemToan2 = toan2.getDiemToan();
		if (DiemToan1 > DiemToan2) {
			return toan1;
		} else {
			if (DiemToan1 < DiemToan2) {
				return toan2;
			} else {
				return null;
			}
		}
	}

	public static void main(String[] args) {
		SinhVien sinhVien1 = new SinhVien().setSV();
		SinhVien sinhVien2 = new SinhVien().setSV();
		SinhVien sinhVien = new SinhVien().findSinhVien(sinhVien1, sinhVien2);
		if (sinhVien == null) {
			System.out.println("Điểm toán 2 sinh viên bằng nhau");
		} else {
			System.out.println("Sinh viên có điểm toán cao hơn là:\n " + sinhVien.viewSV());
		}
	}
}
