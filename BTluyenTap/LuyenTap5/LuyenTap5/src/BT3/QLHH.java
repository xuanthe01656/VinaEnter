package BT3;

public class QLHH {
	private int id;
	private String name;
	private int amount;
	private float price;
	private String dateCreate;
	public QLHH() {
	}
	public QLHH(int id, String name,int amount, float price, String dateCreate) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.dateCreate = dateCreate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}
	@Override
	public String toString() {
		return "ID Hàng hóa: " + id + " - Tên hàng hóa: " + name +" - Số lượng: "+amount+ " - Giá: " + price + " - Ngày nhập: " + dateCreate ;
	}
}
