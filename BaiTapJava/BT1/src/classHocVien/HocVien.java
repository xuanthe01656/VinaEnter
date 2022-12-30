package classHocVien;

import java.util.Scanner;

public class HocVien {
	String hoTen;
	String lop;
	float toan;
	float ly;
	float hoa;

	public HocVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocVien(String hoTen, String lop, float toan, float ly, float hoa) {
		super();
		this.hoTen = hoTen;
		this.lop = lop;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public float getToan() {
		return toan;
	}

	public void setToan(float toan) {
		this.toan = toan;
	}

	public float getLy() {
		return ly;
	}

	public void setLy(float ly) {
		this.ly = ly;
	}

	public float getHoa() {
		return hoa;
	}

	public void setHoa(float hoa) {
		this.hoa = hoa;
	}
	public float NhapDiem() {
		boolean tiepTuc1 = true;
		Scanner input = new Scanner(System.in);
		float DiemHV = 0;
		while (tiepTuc1) {
			float Diem1 = Float.parseFloat(input.nextLine());
			if (Diem1 >= 0 && Diem1 <= 10) {
				DiemHV = Diem1;
				tiepTuc1 = false;
			} else {
				System.out.println("Hãy nhập điểm từ 0- 10");
			}
		}
		return DiemHV;
	}

	public HocVien HV() {
		Scanner input = new Scanner(System.in);
		System.out.println("==NHẬP VÀO THÔNG TIN HỌC VIÊN==");
		System.out.println("Nhập họ tên học viên: ");
		String hoTen = input.nextLine();
		System.out.println("Nhập vào lớp học viên:");
		String lop = input.nextLine();
		System.out.println("Nhập vào Điểm toán:");
		float toan = this.NhapDiem();
		System.out.println("Nhập vào Điểm Lý:");
		float ly = this.NhapDiem();
		System.out.println("Nhập vào Điểm Hóa:");
		float hoa = this.NhapDiem();
		
		HocVien Obj = new HocVien(hoTen, lop, toan, ly, hoa);
		return Obj;
	}

	public float Avg() {
		float toan = this.getToan();
		float ly = this.getLy();
		float hoa = this.getHoa();
		float Avg = (toan + ly + hoa) / 3;
		return Avg;
	}

	public HocVien soSanh(HocVien AvgHocVien1, HocVien AvgHocVien2) {
		float dtb1 = AvgHocVien1.Avg();
		float dtb2 = AvgHocVien2.Avg();
		if (dtb1 > dtb2) {
			return AvgHocVien1;
		} else {
			if (dtb1 < dtb2) {
				return AvgHocVien2;
			} else {
				return null;
			}
		}
	}

	public String Display() {
		return "Tên Học Viên: " +this.hoTen+"\nLớp: "+this.lop+"\nĐiểm toán: "+this.toan+"\nĐiểm lý: "+this.ly+"\nĐiểm hóa: "+this.hoa+"\nĐiểm trung bình: "+this.Avg();
		}
	public static void main(String[] args) {
		HocVien objHV1 = new HocVien().HV();
		HocVien objHV2 = new HocVien().HV();
		HocVien objHV = objHV1.soSanh(objHV1, objHV2);
		if(objHV==null) {
			System.out.println("Hai học viên có điểm trung bình bằng nhau.");
		}else {
			System.out.println("Học viên có điểm trung bình cao hơn là:\n"+objHV.Display());
		}
	}
}
