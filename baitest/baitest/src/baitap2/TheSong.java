package baitap2;

public class TheSong {
	private int id;
	private String name;
	private String date_creat;
	private int view;
	public TheSong() {
		
	}
	public TheSong(int id, String name, String date_creat, int view) {
		this.id = id;
		this.name = name;
		this.date_creat = date_creat;
		this.view = view;
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
	public String getDate_creat() {
		return date_creat;
	}
	public void setDate_creat(String date_creat) {
		this.date_creat = date_creat;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	@Override
	public String toString() {
		return "ID: " + id + " - Tên bài hát: " + name + " - Ngày tạo: " + date_creat + " - Lượt xem: " + view ;
	}
	
}
