package string;

public class String1 {
	public int Dem(String[] str1, String[] str2) {
		int dem = 0;
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i].equals(str2[j])) {
					dem++;
				}
			}
		}
		return dem;
	}
	
	public String[] chuoi3(String[] str1, String[] str2) {
		String1 obj = new String1();
		int dem1 = obj.Dem(str1, str2);
		int dem2 = 0;
		String[] chuoi3 = new String[dem1];
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i].equals(str2[j])) {
					chuoi3[dem2] = str1[i];
					dem2++;
				}
			}
		}
		return chuoi3;
	}

	public static void main(String[] args) {
		String chuoi1 = "Học JAVA rèn luyện sự kiên trì, chịu khó và giúp tăng cường sự phát \r\n"
				+ "triển về tư duy. Ngoài ra nếu rèn luyện được sự kiên trì thì sẽ giúp bạn thành công hơn \r\n"
				+ "trong cuộc sống";
		String chuoi2 = "“Với JAVA, ta có thể tư duy phát triển các dự án web, dự án app";
		int dem = 0;
		String[] str1 = chuoi1.split("\\s");
		String[] str2 = chuoi2.split("\\s");
		
		for (String string : str1) {
			if ("kiên trì".contains(string) && "rèn".contains(string)) {
				dem++;
			}
		}
		String1 obj = new String1();
		int dem2 = obj.Dem(str1, str2);
		System.out.println("\n'kiên trì' và 'rèn' xuất hiện " + dem  + " lần trong chuỗi 1.");
		System.out.println("Số từ trong chuỗi 1 có trong chuỗi 2 là: " + dem2);
		System.out.print("Đó là các từ: ");
		
		String[] chuoi3 = obj.chuoi3(str1, str2);
		for (String string : chuoi3) {
			System.out.print(string + ", ");
		}
	}
}
