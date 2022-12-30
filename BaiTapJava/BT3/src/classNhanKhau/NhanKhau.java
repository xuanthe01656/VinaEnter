package classNhanKhau;

import java.util.Scanner;

public class NhanKhau {
	private String HoTen;
	private String NgaySinh;
	private String GioiTinh;
	private String DiaChi;
	private String NoiCongTac;
	public NhanKhau() {
		
	}
	public NhanKhau(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String noiCongTac) {
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		NoiCongTac = noiCongTac;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getNoiCongTac() {
		return NoiCongTac;
	}
	public void setNoiCongTac(String noiCongTac) {
		NoiCongTac = noiCongTac;
	}
	public NhanKhau NK() {
		Scanner input = new Scanner(System.in);
		System.out.println("==NHẬP VÀO THÔNG TIN NHÂN KHẨU==");
		System.out.println("Nhập vào họ tên: ");
		String HoTen = input.nextLine();
		System.out.println("Nhập vào ngày sinh: ");
		String NgaySinh = input.nextLine();
		System.out.println("Nhập vào giới tính");
		String GioiTinh = input.nextLine();
		System.out.println("Nhập vào địa chỉ hiện nay: ");
		String DiaChi = input.nextLine();
		System.out.println("Nhập vào nơi công tác: ");
		String NoiCongTac = input.nextLine();
		NhanKhau NK = new NhanKhau(HoTen, NgaySinh, GioiTinh, DiaChi, NoiCongTac);
		return NK;
	}
	public String Display() {
		return "Họ Tên: "+this.HoTen+"\nNgày Sinh: "+this.NgaySinh+"\nGiới Tính: "+this.GioiTinh+"\nĐịa Chỉ Hiện Nay: "+this.DiaChi+"\nNơi Công Tác: "+this.NoiCongTac;
	}
}
class QuanLyDanSo {
	public static void main(String[] args) {
		NhanKhau nhanKhau1 = new NhanKhau().NK();
		System.out.println("Thông Tin Nhân Khẩu 1:\n"+nhanKhau1.Display());
	}
}
